package server.entity;

import java.io.Serializable;

public class PlaceCoordinate implements Serializable {

    private static final long serialVersionUID = 6549685098267753692L;
    private int row;
    private int column;

    public PlaceCoordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
