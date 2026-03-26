package dev.ismav.productcatalogservice.dtos;

import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class SearchRequestDTO {
    private String query;
    private Integer pageNo;
    private Integer pageSize;

    private List<SortParams> sortParams;

    public List<SortParams> getSortParams() {
        return sortParams;
    }

    public void setSortParams(List<SortParams> sortParams) {
        this.sortParams = sortParams;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }


}
