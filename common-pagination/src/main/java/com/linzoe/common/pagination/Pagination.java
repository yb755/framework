package com.linzoe.common.pagination;

import java.util.List;

import lombok.Data;

@Data
public class Pagination<T> {

	private List<T> list;

	private int totalCount;

	private int page;

	private int pageSize;
}
