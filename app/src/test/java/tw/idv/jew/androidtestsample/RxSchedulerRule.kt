package tw.idv.jew.androidtestsample

import io.reactivex.rxjava3.android.plugins.RxAndroidPlugins
import io.reactivex.rxjava3.internal.schedulers.TrampolineScheduler
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import org.junit.rules.TestWatcher
import org.junit.runner.Description

class RxSchedulerRule : TestWatcher() {
    override fun starting(description: Description?) {
        super.starting(description)
        RxJavaPlugins.setInitIoSchedulerHandler {
            TrampolineScheduler.instance()
        }
        RxJavaPlugins.setComputationSchedulerHandler {
            TrampolineScheduler.instance()
        }
        RxJavaPlugins.setInitNewThreadSchedulerHandler {
            TrampolineScheduler.instance()
        }
        RxJavaPlugins.setInitSingleSchedulerHandler {
            TrampolineScheduler.instance()
        }
        RxAndroidPlugins.setInitMainThreadSchedulerHandler {
            TrampolineScheduler.instance()
        }
    }

    override fun finished(description: Description?) {
        super.finished(description)
        RxJavaPlugins.reset()
        RxAndroidPlugins.reset()
    }
}