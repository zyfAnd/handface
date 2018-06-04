package com.soyeah.model;

import java.util.Map;

/**
 * @Author Zhang Yanfu
 * @Date 2018/4/29.
 * @Email 1105564280@qq.com
 */
public class TemplateMsg  {

//    "touser": "OPENID",
//            "template_id": "TEMPLATE_ID",
//            "page": "index",
//            "form_id": "FORMID",
//            "data": {
//        "keyword1": {
//            "value": "339208499",
//                    "color": "#173177"
//        },
//        "keyword2": {
//            "value": "2015年01月05日 12:30",
//                    "color": "#173177"
//        },
//        "keyword3": {
//            "value": "粤海喜来登酒店",
//                    "color": "#173177"
//        } ,
//        "keyword4": {
//            "value": "广州市天河区天河路208号",
//                    "color": "#173177"
//        }
//    },
//            "emphasis_keyword": "keyword1.DATA"

    private String touser;
    private String template_id;
    private String page;
    private String form_id;
    private Map<String,KeyWord> data;
    private String emphasis_keyword;

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getForm_id() {
        return form_id;
    }

    public void setForm_id(String form_id) {
        this.form_id = form_id;
    }

    public Map<String, KeyWord> getData() {
        return data;
    }

    public void setData(Map<String, KeyWord> data) {
        this.data = data;
    }

    public String getEmphasis_keyword() {
        return emphasis_keyword;
    }

    public void setEmphasis_keyword(String emphasis_keyword) {
        this.emphasis_keyword = emphasis_keyword;
    }
}
