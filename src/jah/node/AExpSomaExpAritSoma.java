/* This file was generated by SableCC (http://www.sablecc.org/). */

package jah.node;

import jah.analysis.*;

@SuppressWarnings("nls")
public final class AExpSomaExpAritSoma extends PAritSoma
{
    private PExp _exp_;
    private TSoma _soma_;
    private PAritSub _aritSub_;

    public AExpSomaExpAritSoma()
    {
        // Constructor
    }

    public AExpSomaExpAritSoma(
        @SuppressWarnings("hiding") PExp _exp_,
        @SuppressWarnings("hiding") TSoma _soma_,
        @SuppressWarnings("hiding") PAritSub _aritSub_)
    {
        // Constructor
        setExp(_exp_);

        setSoma(_soma_);

        setAritSub(_aritSub_);

    }

    @Override
    public Object clone()
    {
        return new AExpSomaExpAritSoma(
            cloneNode(this._exp_),
            cloneNode(this._soma_),
            cloneNode(this._aritSub_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAExpSomaExpAritSoma(this);
    }

    public PExp getExp()
    {
        return this._exp_;
    }

    public void setExp(PExp node)
    {
        if(this._exp_ != null)
        {
            this._exp_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._exp_ = node;
    }

    public TSoma getSoma()
    {
        return this._soma_;
    }

    public void setSoma(TSoma node)
    {
        if(this._soma_ != null)
        {
            this._soma_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._soma_ = node;
    }

    public PAritSub getAritSub()
    {
        return this._aritSub_;
    }

    public void setAritSub(PAritSub node)
    {
        if(this._aritSub_ != null)
        {
            this._aritSub_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._aritSub_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._exp_)
            + toString(this._soma_)
            + toString(this._aritSub_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._exp_ == child)
        {
            this._exp_ = null;
            return;
        }

        if(this._soma_ == child)
        {
            this._soma_ = null;
            return;
        }

        if(this._aritSub_ == child)
        {
            this._aritSub_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._exp_ == oldChild)
        {
            setExp((PExp) newChild);
            return;
        }

        if(this._soma_ == oldChild)
        {
            setSoma((TSoma) newChild);
            return;
        }

        if(this._aritSub_ == oldChild)
        {
            setAritSub((PAritSub) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
