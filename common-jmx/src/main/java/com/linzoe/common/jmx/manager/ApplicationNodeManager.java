/**
 * Copyright © 2014 Winit Corp. All rights reserved.
 * This software is proprietary to and embodies the confidential
 * technology of Winit Corp.  Possession, use, or copying
 * of this software and media is authorized only pursuant to a
 * valid written license from Winit Corp or an authorized sublicensor.
 */
package com.linzoe.common.jmx.manager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.linzoe.common.jackson.ObjectMapperUtil;
import com.linzoe.common.jmx.bo.ApplicationNodeBO;

public class ApplicationNodeManager {

	private static final Logger logger = LoggerFactory.getLogger(ApplicationNodeManager.class);

	public static ConcurrentMap<String, ApplicationNodeBO> nodesMap = new ConcurrentHashMap<>();

	private static String filePath = "";
	
	private ObjectMapper objectMapper=ObjectMapperUtil.getObjectMapper();

	@SuppressWarnings("unchecked")
	public ApplicationNodeManager(Resource resource) {
		try {
			File file = new File(resource.getURL().getPath());
			filePath = resource.getURL().getPath();
			String content = readContent(file);
			logger.info("初始化应用节点内容. content:{}", content);
			List<Map<String, String>> list = objectMapper.readValue(content, List.class);
			if (list != null) {
				for (Map<String, String> map : list) {
					ApplicationNodeBO node = objectMapper.readValue(objectMapper.writeValueAsString(map), ApplicationNodeBO.class);
					nodesMap.put(String.valueOf(node.getId()), node);
				}
			}
			logger.info("初始化了{}个节点. ", nodesMap.size());
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
	}

	public void addNode(ApplicationNodeBO node) throws JsonProcessingException {
		Date time = new Date();
		node.setId(time.getTime());
		nodesMap.put(String.valueOf(node.getId()), node);
		logger.info("成功增加一个新节点. node:{}", objectMapper.writeValueAsString(node));
		writeContent();
	}

	public void updateNode(ApplicationNodeBO node) throws JsonProcessingException {
		ApplicationNodeBO nd = nodesMap.get(String.valueOf(node.getId()));
		if (nd != null) {
			nodesMap.put(String.valueOf(node.getId()), node);
			logger.info("成功更新一个节点. node:{}", objectMapper.writeValueAsString(node));
		} else {
			addNode(node);
		}

		writeContent();
	}

	public void removeNode(long nodeId) {
		nodesMap.remove(String.valueOf(nodeId));
		logger.info("成功删除一个节点. nodeId:{}", nodeId);
		writeContent();
	}

	public ApplicationNodeBO getNode(long nodeId) {
		return nodesMap.get(String.valueOf(nodeId));
	}

	public List<ApplicationNodeBO> getNodes() {
		List<ApplicationNodeBO> list = new ArrayList<>();
		if (!nodesMap.isEmpty()) {
			Iterator<Entry<String, ApplicationNodeBO>> it = nodesMap.entrySet().iterator();
			while (it.hasNext()) {
				Entry<String, ApplicationNodeBO> en = it.next();
				list.add(en.getValue());
			}
		}

		return list;
	}

	private String readContent(File file) {
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
				sb.append(tempString);
			}
			reader.close();
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
					logger.error(e1.getMessage(), e1);
				}
			}
		}

		return sb.toString();
	}

	private void writeContent() {
		try {
			FileWriter fw = new FileWriter(filePath, false);
			BufferedWriter bw = new BufferedWriter(fw);
			List<ApplicationNodeBO> list = getNodes();
			if (list.size() > 0) {
				String content = objectMapper.writeValueAsString(list);
				bw.write(content);
				logger.info("即将更新节点内容. content:{}", content);
			} else {
				bw.write("");
			}
			bw.close();
			fw.close();
			logger.info("更新成功.");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

}
