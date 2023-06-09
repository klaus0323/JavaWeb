package pojo;

import java.util.List;

public class PageBean<T> {

    //对应的总记录
    private int totalCount;

    // 当前页数据集合
    private List<T> rows;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
