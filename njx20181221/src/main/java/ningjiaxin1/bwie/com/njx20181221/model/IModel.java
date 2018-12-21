package ningjiaxin1.bwie.com.njx20181221.model;

import java.util.Map;

import ningjiaxin1.bwie.com.njx20181221.untils.MCallBack;

public interface IModel {
    void setRequest(String url, Map<String,String> map, Class clazz, MCallBack callBack);
}
