package com.asianrapid.talin.common.enums;
/**
 * @ClassName SystemConst
 * @Author Nio
 * @Date 2019/8/1 0001
 * @Version V1.0
 **/
public enum SystemModeEnum {
    DEV("0", "开发"), TEST("1", "测试"), MASTER("2", "生产");

    private String code;

    private String name;

    private SystemModeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * 输出values
     *
     * @param
     * @return
     */
    public static String getValuesToString() {
        StringBuffer result = new StringBuffer();
        for (SystemModeEnum enumType : SystemModeEnum.values()) {
            result.append(" " + enumType.getName());
        }
        return result.toString();
    }

    /**
     * 输出values
     *
     * @param
     * @return
     */
    public static String getCodesToString() {
        StringBuffer result = new StringBuffer();
        for (SystemModeEnum enumType : SystemModeEnum.values()) {
            result.append(" " + enumType.getCode());
        }
        return result.toString();
    }

    /**
     * 根据名称得到码
     *
     * @param name
     * @return
     */
    public static String getCode(String name) {
        for (SystemModeEnum enumType : SystemModeEnum.values()) {
            if (enumType.getName().equals(name)) {
                return enumType.getCode();
            }
        }
        return "";
    }

    /**
     * 根据码得到名称
     *
     * @param code
     * @return
     */
    public static String getName(String code) {
        for (SystemModeEnum enumType : SystemModeEnum.values()) {
            if (enumType.getCode().equals(code)) {
                return enumType.getName();
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
