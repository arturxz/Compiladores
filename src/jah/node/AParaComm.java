/* This file was generated by SableCC (http://www.sablecc.org/). */

package jah.node;

import jah.analysis.*;

@SuppressWarnings("nls")
public final class AParaComm extends PComm
{
    private PCommPara _commPara_;

    public AParaComm()
    {
        // Constructor
    }

    public AParaComm(
        @SuppressWarnings("hiding") PCommPara _commPara_)
    {
        // Constructor
        setCommPara(_commPara_);

    }

    @Override
    public Object clone()
    {
        return new AParaComm(
            cloneNode(this._commPara_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAParaComm(this);
    }

    public PCommPara getCommPara()
    {
        return this._commPara_;
    }

    public void setCommPara(PCommPara node)
    {
        if(this._commPara_ != null)
        {
            this._commPara_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._commPara_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._commPara_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._commPara_ == child)
        {
            this._commPara_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._commPara_ == oldChild)
        {
            setCommPara((PCommPara) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
