/* This file was generated by SableCC (http://www.sablecc.org/). */

package jah.node;

import jah.analysis.*;

@SuppressWarnings("nls")
public final class ANadaCommLeia extends PCommLeia
{

    public ANadaCommLeia()
    {
        // Constructor
    }

    @Override
    public Object clone()
    {
        return new ANadaCommLeia();
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseANadaCommLeia(this);
    }

    @Override
    public String toString()
    {
        return "";
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        throw new RuntimeException("Not a child.");
    }
}
