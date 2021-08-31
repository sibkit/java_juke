package juke.swing.layouts;

import java.awt.*;

public class VerticalBoxLayout extends Layout
{
    private boolean fitToWidth = false;
    private int vGap =0;


    @Override
    public Dimension minimumLayoutSize(Container parent)
    {
        int w = 0,h =0;
        for(Component comp : parent.getComponents())
        {
            if(comp.getMinimumSize().width>w)
                w = comp.getMinimumSize().width;
            h+=comp.getMinimumSize().height;
            h+= getVGap();
        }
        h-= getVGap();
        return new Dimension(w+getLeftIndent()+getRightIndent(),h+getTopIndent()+getBottomIndent());
    }

    @Override
    public void layoutContainer(Container parent)
    {
        Dimension prefSize = parent.getPreferredSize();
        int y=getTopIndent();
        for(Component comp : parent.getComponents())
        {
            int w;
            if(isFitToWidth())
                w = parent.getWidth()-getRightIndent()-getLeftIndent();
            else
                w = comp.getMinimumSize().width;

            comp.setBounds(getLeftIndent(),y,w,comp.getMinimumSize().height);
            y+=comp.getMinimumSize().height+ getVGap();
        }
    }

    public boolean isFitToWidth()
    {
        return fitToWidth;
    }

    public void setFitToWidth(boolean fitToWidth)
    {
        this.fitToWidth = fitToWidth;
    }

    public int getVGap()
    {
        return vGap;
    }

    public void setVGap(int vGap)
    {
        this.vGap = vGap;
    }
}
