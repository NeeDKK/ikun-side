package ikunside;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.JBColor;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class MyToolWindowFactory implements ToolWindowFactory {

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        ContentFactory factory = ContentFactory.SERVICE.getInstance();
        //final ContentFactory factory = ContentFactory.getInstance();
        {
            JPanel panel = new JPanel();
            JLabel label = new JLabel("");
            //URL resource = getClass().getResource("bs.gif");
            String url = "https://needkk-1304874805.cos.ap-nanjing.myqcloud.com/zt.gif";
            URL urlMikro = null;
            try {
                urlMikro = new URL(url);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
            label.setIcon(new ImageIcon(urlMikro));
            label.setFont(new Font("宋体", Font.BOLD, 32));
            label.setForeground(JBColor.BLUE);
            panel.add(label);
            final Content content1 = factory.createContent(panel, "ikun forver", false);
            toolWindow.getContentManager().addContent(content1);
        }
        {
            JPanel panel = new JPanel();
            JLabel label = new JLabel("");
            String url = "https://needkk-1304874805.cos.ap-nanjing.myqcloud.com/mikro.gif";
            URL urlbs = null;
            try {
                urlbs = new URL(url);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
            label.setIcon(new ImageIcon(urlbs));
            label.setFont(new Font("宋体", Font.BOLD, 32));
            label.setForeground(JBColor.RED);
            panel.add(label);
            final Content content1 = factory.createContent(panel, "forver ikun", true);
            toolWindow.getContentManager().addContent(content1);
        }
    }
}
