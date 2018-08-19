/* This file was generated by SableCC (http://www.sablecc.org/). */

package jah.node;

import jah.analysis.*;

@SuppressWarnings("nls")
public final class AAlgoExpLogCommEscreva extends PCommEscreva
{
    private PExpLogica _expLogica_;
    private PCommEscreva _commEscreva_;

    public AAlgoExpLogCommEscreva()
    {
        // Constructor
    }

    public AAlgoExpLogCommEscreva(
        @SuppressWarnings("hiding") PExpLogica _expLogica_,
        @SuppressWarnings("hiding") PCommEscreva _commEscreva_)
    {
        // Constructor
        setExpLogica(_expLogica_);

        setCommEscreva(_commEscreva_);

    }

    @Override
    public Object clone()
    {
        return new AAlgoExpLogCommEscreva(
            cloneNode(this._expLogica_),
            cloneNode(this._commEscreva_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAAlgoExpLogCommEscreva(this);
    }

    public PExpLogica getExpLogica()
    {
        return this._expLogica_;
    }

    public void setExpLogica(PExpLogica node)
    {
        if(this._expLogica_ != null)
        {
            this._expLogica_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expLogica_ = node;
    }

    public PCommEscreva getCommEscreva()
    {
        return this._commEscreva_;
    }

    public void setCommEscreva(PCommEscreva node)
    {
        if(this._commEscreva_ != null)
        {
            this._commEscreva_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._commEscreva_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._expLogica_)
            + toString(this._commEscreva_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._expLogica_ == child)
        {
            this._expLogica_ = null;
            return;
        }

        if(this._commEscreva_ == child)
        {
            this._commEscreva_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._expLogica_ == oldChild)
        {
            setExpLogica((PExpLogica) newChild);
            return;
        }

        if(this._commEscreva_ == oldChild)
        {
            setCommEscreva((PCommEscreva) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
