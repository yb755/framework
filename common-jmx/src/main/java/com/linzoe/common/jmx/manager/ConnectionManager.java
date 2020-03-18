package com.linzoe.common.jmx.manager;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import javax.management.MBeanInfo;
import javax.management.MBeanOperationInfo;
import javax.management.MBeanParameterInfo;
import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import org.springframework.stereotype.Service;

import com.linzoe.common.jmx.bo.ApplicationNodeBO;
import com.linzoe.common.jmx.bo.Operation;

@Service("connectionManager")
public class ConnectionManager {

	private static final String JMX_URL = "service:jmx:rmi:///jndi/rmi://{0}:{1}/jmxrmi";

	public String invoke(ApplicationNodeBO node, String opName, String[] params) throws Exception {
		MBeanServerConnection connection = getConnectiont(node);
		String[] pTypes = null;
		if (params == null || params.length == 0) {
			pTypes = new String[] {};
		} else {
			pTypes = new String[params.length];
			for (int i = 0; i < pTypes.length; i++) {
				pTypes[i] = "java.lang.String";
			}
		}
		Object result2 = connection.invoke(new ObjectName(node.getMbName()), opName, params, pTypes);
		return String.valueOf(result2);
	}

	public List<Operation> findMBeanOp(ApplicationNodeBO node) throws Exception {
		List<Operation> list = new ArrayList<>();
		MBeanInfo info = getMBeanInfo(node);
		MBeanOperationInfo[] ops = info.getOperations();
		if (ops != null) {
			for (MBeanOperationInfo mBeanOperationInfo : ops) {
				Operation operation = new Operation();
				String opName = mBeanOperationInfo.getName();
				operation.setOpName(opName);
				operation.setReturnType(mBeanOperationInfo.getReturnType());
				MBeanParameterInfo[] params = mBeanOperationInfo.getSignature();
				List<String> fields = new ArrayList<>();
				for (MBeanParameterInfo mBeanParameterInfo : params) {
					fields.add(mBeanParameterInfo.getDescription());
				}
				operation.setFields(fields);
				operation.setNodeId(node.getId());

				list.add(operation);
			}
		}

		return list;
	}

	private MBeanInfo getMBeanInfo(ApplicationNodeBO node) throws Exception {
		MBeanServerConnection connection = getConnectiont(node);
		MBeanInfo info = connection.getMBeanInfo(new ObjectName(node.getMbName()));
		return info;
	}

	private MBeanServerConnection getConnectiont(ApplicationNodeBO node) throws Exception {
		String url = MessageFormat.format(JMX_URL, node.getIp(), node.getJmxPort());
		JMXServiceURL serviceURL = new JMXServiceURL(url);
		JMXConnector connector = JMXConnectorFactory.connect(serviceURL);
		MBeanServerConnection connection = connector.getMBeanServerConnection();
		return connection;
	}

}
