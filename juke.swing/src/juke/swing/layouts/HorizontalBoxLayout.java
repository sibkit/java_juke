package juke.swing.layouts;

import java.awt.*;

public class HorizontalBoxLayout extends Layout
{
    private boolean fitToHeight = false;
    private int hGap =0;

    @Override
    public Dimension minimumLayoutSize(Container parent)
    {
        int w = 0,h =0;
        for(Component comp : parent.getComponents())
        {
            if(comp.getMinimumSize().height>h)
                h = comp.getMinimumSize().height;
            w+=comp.getMinimumSize().width;
            w+= getHGap();
        }
        w-= getHGap();
        return new Dimension(w+ getLeftIndent() + getRightIndent(),h+ getTopIndent() + getBottomIndent());
    }

    @Override
    public void layoutContainer(Container parent)
    {
        Dimension prefSize = parent.getPreferredSize();
        int x= getLeftIndent();
        for(Component comp : parent.getComponents())
        {
            int h;
            if(isFitToHeight())
                h = prefSize.height- getBottomIndent() - getTopIndent();
            else
                h = comp.getMinimumSize().height;

            comp.setBounds(x, getTopIndent(),comp.getMinimumSize().width,h);
            x+=comp.getMinimumSize().width+ getHGap();
        }
    }

    public boolean isFitToHeight()
    {
        return fitToHeight;
    }

    public void setFitToHeight(boolean fitToHeight)
    {
        this.fitToHeight = fitToHeight;
    }

    public int getHGap()
    {
        return hGap;
    }

    public void setHGap(int hGap)
    {
        this.hGap = hGap;
    }

}

