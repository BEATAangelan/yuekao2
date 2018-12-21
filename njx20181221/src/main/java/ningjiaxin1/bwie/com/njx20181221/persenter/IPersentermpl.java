package ningjiaxin1.bwie.com.njx20181221.persenter;

import java.util.Map;

import ningjiaxin1.bwie.com.njx20181221.model.IModelmpl;
import ningjiaxin1.bwie.com.njx20181221.untils.MCallBack;
import ningjiaxin1.bwie.com.njx20181221.view.IView;

public class IPersentermpl implements IPersenter {
    private IModelmpl miModelmpl;
    private IView miView;
    public IPersentermpl(IView iView){
        miModelmpl=new IModelmpl();
        miView=iView;
    }
    @Override
    public void startRequest(String url, Map<String, String> map, Class clazz) {
        miModelmpl.setRequest(url, map, clazz, new MCallBack() {
            @Override
            public void setdata(Object o) {
                miView.setOnSuccess(o);
            }
        });
    }
    //解绑
    public void onDestoy(){
        if(miModelmpl!=null){
            miModelmpl=null;
        }if(miView!=null){
            miView=null;
        }
    }
}
