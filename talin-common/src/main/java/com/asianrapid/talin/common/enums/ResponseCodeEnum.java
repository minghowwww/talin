package com.asianrapid.talin.common.enums;

public enum ResponseCodeEnum {

    OK("0", "正常"), ERROR("1", "错误"), WARNING("2", "警告"), DUPLICATION("3", "重复点击"), CHECK("4", "校验");

    private String code;

    private String name;

    private ResponseCodeEnum(String code, String name) {
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
        for (SystemCodeEnum enumType : SystemCodeEnum.values()) {
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
        for (SystemCodeEnum enumType : SystemCodeEnum.values()) {
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
        for (SystemCodeEnum enumType : SystemCodeEnum.values()) {
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
        for (SystemCodeEnum enumType : SystemCodeEnum.values()) {
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

    public boolean equals(String code) {
        return this.code.equals(code);
    }

    public boolean equals(int code) {
        return Integer.parseInt(this.code) == code;
    }
}
