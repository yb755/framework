package com.linzoe.common.solr;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.ModifiableSolrParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SolrUtil {

	// http://192.168.22.128:8081/solr
	@Value("${solr.server.url:}")
	public String baseURL;

	public HttpSolrServer server = null;

	@PostConstruct
	public void init() {
		server = new HttpSolrServer(baseURL);
	}

	@PreDestroy
	public void destroy() {
		server.shutdown();
		server = null;
	}

	public void add(Serializable object) throws IOException, SolrServerException {
		server.addBean(object);
		server.commit();
	}

	public void addList(List<Serializable> list) throws SolrServerException, IOException {
		server.addBeans(list);
		server.commit();
	}

	public void deleteById(String id) throws SolrServerException, IOException {
		server.deleteById(id);
	}

	public void deleteByQuery(String query) throws SolrServerException, IOException {
		server.deleteByQuery(query);
		server.commit();
	}

	public SolrDocumentList query(String queryWord, int offset, int limit) throws SolrServerException {
		SolrQuery query = new SolrQuery(queryWord);
		query.setStart(offset);// 起始页
		query.setRows(limit);// 每页显示数量
		QueryResponse rsp = server.query(query);
		SolrDocumentList results = rsp.getResults();
		return results;
	}

	public SolrDocumentList queryMulti(ModifiableSolrParams params) throws SolrServerException {
		QueryResponse response = server.query(params);
		SolrDocumentList list = response.getResults();
		return list;
	}

	public SolrDocumentList query(SolrQuery query) throws SolrServerException {
		QueryResponse response = server.query(query);
		SolrDocumentList list = response.getResults();
		return list;
	}
}
