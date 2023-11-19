package edu.project3.Models;

import java.util.ArrayList;
import java.util.List;

public class TableCreater {
    private final String tableTitle;
    private final List<String> titles;
    private final List<List<String>> rows;

    public TableCreater(String tableTitle, List<String> titles) {
        this.tableTitle = tableTitle;
        this.titles = titles;
        rows = new ArrayList<>();
    }

    public void addRow(List<String> row) {
        if (titles.size() != row.size()) {
            return;
        }

        rows.add(row);
    }

    public String getTableTitle() {
        return tableTitle;
    }

    public List<String> getTitles() {
        return titles;
    }

    public List<List<String>> getRows() {
        return rows;
    }
}
