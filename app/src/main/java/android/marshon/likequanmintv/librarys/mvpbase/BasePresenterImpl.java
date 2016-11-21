package android.marshon.likequanmintv.librarys.mvpbase;

import android.support.annotation.NonNull;

import rx.subscriptions.CompositeSubscription;

/**
 * Created by It.Marshon on 2016/11/21 0021 11:40
 * desc: 该BasePresenterImpl 主要全局处理
 */

public class BasePresenterImpl<T extends BaseView> implements BasePresenter<T> {

    //presenter的subscription管理器
    protected CompositeSubscription mSubscriptions=new CompositeSubscription();
    protected T mPresenterView;
    @Override
    public void onCreate() {

    }


    //base 帮忙全局处理
    @Override
    public void attachView(@NonNull T baseView) {
        mPresenterView=baseView;
    }

    //
    @Override
    public void onDestroy() {
        if (!mSubscriptions.isUnsubscribed()){
            mSubscriptions.unsubscribe();
        }
        mSubscriptions=null;

    }


}
