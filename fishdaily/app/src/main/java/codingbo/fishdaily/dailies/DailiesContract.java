package codingbo.fishdaily.dailies;

import codingbo.fishdaily.BasePresenter;
import codingbo.fishdaily.BaseView;

/**
 * Created by bob
 * on 17.7.14.
 */

public interface DailiesContract {

    interface View extends BaseView<Presenter> {
        /**
         * 显示或隐藏加载标识
         *
         * @param active true 显示, false 隐藏
         */
        void setLoadingIndicator(boolean active);

        /**
         * 显示日常列表
         */
//        void showDailies(List<Daily> dailies);

        /**
         * 显示空界面
         */
        void showEmpty();

        /**
         * 添加日常
         */
        void addDaily();

        /**
         * 日常详情界面
         *
         * @param dailyId 日常Id
         */
        void showDailyDetailUi(String dailyId);

        /**
         * 显示加载失败界面
         */
        void showFailed();

    }

    interface Presenter extends BasePresenter {
        /**
         * activity result
         *
         * @param requestCode requestCode
         * @param resultCode  resultCode
         */
        void result(int requestCode, int resultCode);

        /**
         * 读取日常列表
         *
         * @param forceUpdate 强制更新
         */
        void loadDailies(boolean forceUpdate);

        /**
         * 新增日常
         */
        void addNewDaily();

        /**
         * 日常详情
         */
//        void openDailyDetail(Daily daily);


    }
}
