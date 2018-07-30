/* This file was generated by SableCC (http://www.sablecc.org/). */

package jah.node;

import jah.analysis.*;

@SuppressWarnings("nls")
public final class AXorExpLogica extends PExpLogica
{
    private PExpLogica _expLogica_;
    private TXor _xor_;
    private PLogPrecUm _logPrecUm_;

    public AXorExpLogica()
    {
        // Constructor
    }

    public AXorExpLogica(
        @SuppressWarnings("hiding") PExpLogica _expLogica_,
        @SuppressWarnings("hiding") TXor _xor_,
        @SuppressWarnings("hiding") PLogPrecUm _logPrecUm_)
    {
        // Constructor
        setExpLogica(_expLogica_);

        setXor(_xor_);

        setLogPrecUm(_logPrecUm_);

    }

    @Override
    public Object clone()
    {
        return new AXorExpLogica(
            cloneNode(this._expLogica_),
            cloneNode(this._xor_),
            cloneNode(this._logPrecUm_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAXorExpLogica(this);
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

    public TXor getXor()
    {
        return this._xor_;
    }

    public void setXor(TXor node)
    {
        if(this._xor_ != null)
        {
            this._xor_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._xor_ = node;
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
            + toString(this._xor_)
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

        if(this._xor_ == child)
        {
            this._xor_ = null;
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

        if(this._xor_ == oldChild)
        {
            setXor((TXor) newChild);
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