package ikunside;

import com.intellij.notification.*;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowManager;
import org.jetbrains.annotations.NotNull;

public class Ikun extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        NotificationGroup notificationGroup = new NotificationGroup("ikun notification", NotificationDisplayType.BALLOON, false);
        Notification notification = notificationGroup.createNotification("IKun !!!", "", "Mikro is the best iKuner", NotificationType.INFORMATION);
        Notifications.Bus.notify(notification);


        //NotificationGroupManager.getInstance().getNotificationGroup("ikun notification")
        //        .createNotification("IKun !!!", "Mikro is the best iKuner", NotificationType.INFORMATION)
        notification.addAction(new NotificationAction("你干嘛哈嗨哟") {
            @Override
            public void actionPerformed(@NotNull AnActionEvent e, @NotNull Notification notification) {
                // 获取侧边栏窗口的实例
                ToolWindowManager toolWindowManager = ToolWindowManager.getInstance(e.getProject());
                ToolWindow toolWindow = toolWindowManager.getToolWindow("Mikro_ikun");
                // 显示或隐藏窗口
                if (toolWindow != null) {
                    toolWindow.show(null);
                }
            }
        }).notify(e.getProject());
    }

}
