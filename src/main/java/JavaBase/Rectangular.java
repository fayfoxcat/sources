package JavaBase;

public class Rectangular {

    /**
     * 长
     */
    private Integer length;

    public Rectangular() {
    }

    public Rectangular(Integer length, Integer wide) {
        this.length = length;
        this.wide = wide;
    }

    /**
     * 宽
     */
    private Integer wide;

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getWide() {
        return wide;
    }

    public void setWide(Integer wide) {
        this.wide = wide;
    }
}
