package juke.swing;

import juke.events.EventEmitter;
import juke.events.BaseEventEmitter;
import juke.view.ViewForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.EventObject;

public abstract class SwingViewFormConnector implements ViewForm
{
    String caption;
    private Container content;
    Rectangle bounds;

    private Window window;

    BaseEventEmitter<EventObject> closedEmitter = new BaseEventEmitter<>();

    public EventEmitter<EventObject> getClosedEmitter()
    {
        return closedEmitter;
    }

    public SwingViewFormConnector()
    {
        content = createContent();
    }

    private void prepareForShow(Window window)
    {
        if(window instanceof JFrame)
        {
            ((JFrame)window).setTitle(caption);
            ((JFrame)window).setContentPane(content);
        }
        if(window instanceof JDialog)
        {
            ((JDialog)window).setTitle(caption);
            ((JDialog)window).setContentPane(content);
        }

        window.pack();
        if(bounds!=null)
            window.setBounds(bounds);
        window.addComponentListener(new ComponentListener()
        {
            @Override
            public void componentResized(ComponentEvent e)
            {
                SwingViewFormConnector.this.bounds = window.getBounds();
            }

            @Override
            public void componentMoved(ComponentEvent e)
            {
                SwingViewFormConnector.this.bounds = window.getBounds();
            }

            @Override
            public void componentShown(ComponentEvent e)
            {

            }

            @Override
            public void componentHidden(ComponentEvent e)
            {

            }
        });


        window.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e)
            {
            }

            @Override
            public void windowClosing(WindowEvent e)
            {
                closedEmitter.emit(new EventObject(this));
            }

            @Override
            public void windowClosed(WindowEvent e)
            {

            }

            @Override
            public void windowIconified(WindowEvent e)
            {
            }

            @Override
            public void windowDeiconified(WindowEvent e)
            {
            }

            @Override
            public void windowActivated(WindowEvent e)
            {
            }

            @Override
            public void windowDeactivated(WindowEvent e)
            {
            }
        });

    }

    protected abstract Container createContent();


    @Override
    public String getCaption()
    {
        return this.caption;
    }

    @Override
    public void setCaption(String caption)
    {
        this.caption = caption;
    }

    @Override
    public void close()
    {
        window.setVisible(false);
        window.dispose();
        for(ComponentListener cl : window.getComponentListeners())
            window.removeComponentListener(cl);
        window = null;
    }

    @Override
    public void hide()
    {
        window.setVisible(false);
    }

    @Override
    public void show(ViewForm view)
    {
        if(window!=null)
            close();

        if(view==null)
        {
            window = new JFrame();
        }
        else
            window = new JDialog((Window)view);
        prepareForShow(window);

        int w = 1200;
        int h = 800;

        int sw = Toolkit.getDefaultToolkit().getScreenSize().width;
        int sh = Toolkit.getDefaultToolkit().getScreenSize().height;

        window.setBounds((sw-w)/2,(sh-h)/2,w,h);

        window.setSize(w,h);

        window.setVisible(true);
    }

    @Override
    public void showModal(ViewForm view)
    {
        window = new JDialog((Window)view);
        prepareForShow(window);
        window.setVisible(true);
    }

    public Container getContent()
    {
        return content;
    }


}
