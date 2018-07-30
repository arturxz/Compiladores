/* This file was generated by SableCC (http://www.sablecc.org/). */

package jah.node;

import jah.analysis.*;

@SuppressWarnings("nls")
public final class AAndExpLogica extends PExpLogica
{
    private PExpLogica _expLogica_;
    private TE _e_;
    private PLogPrecUm _logPrecUm_;

    public AAndExpLogica()
    {
        // Constructor
    }

    public AAndExpLogica(
        @SuppressWarnings("hiding") PExpLogica _expLogica_,
        @SuppressWarnings("hiding") TE _e_,
        @SuppressWarnings("hiding") PLogPrecUm _logPrecUm_)
    {
        // Constructor
        setExpLogica(_expLogica_);

        setE(_e_);

        setLogPrecUm(_logPrecUm_);

    }

    @Override
    public Object clone()
    {
        return new AAndExpLogica(
            cloneNode(this._expLogica_),
            cloneNode(this._e_),
            cloneNode(this._logPrecUm_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAAndExpLogica(this);
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

    public TE getE()
    {
        return this._e_;
    }

    public void setE(TE node)
    {
        if(this._e_ != null)
        {
            this._e_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._e_ = node;
    }

    public PLogPrecUm getLogPrecUm()
    {
        return this._logPrecUm_;
    }

    public void setLogPrecUm(PLogPrecUm node)
    {
        if(this._logPrecUm_ != null)
        {
            this._logPrecUm_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._logPrecUm_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._expLogica_)
            + toString(this._e_)
            + toString(this._logPrecUm_);
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

        if(this._e_ == child)
        {
            this._e_ = null;
            return;
        }

        if(this._logPrecUm_ == child)
        {
            this._logPrecUm_ = null;
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

        if(this._e_ == oldChild)
        {
            setE((TE) newChild);
            return;
        }

        if(this._logPrecUm_ == oldChild)
        {
            setLogPrecUm((PLogPrecUm) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}