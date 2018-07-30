/* This file was generated by SableCC (http://www.sablecc.org/). */

package jah.node;

import jah.analysis.*;

@SuppressWarnings("nls")
public final class AMultTermo extends PTermo
{
    private PTermo _termo_;
    private TMult _mult_;
    private PExpFinal _expFinal_;

    public AMultTermo()
    {
        // Constructor
    }

    public AMultTermo(
        @SuppressWarnings("hiding") PTermo _termo_,
        @SuppressWarnings("hiding") TMult _mult_,
        @SuppressWarnings("hiding") PExpFinal _expFinal_)
    {
        // Constructor
        setTermo(_termo_);

        setMult(_mult_);

        setExpFinal(_expFinal_);

    }

    @Override
    public Object clone()
    {
        return new AMultTermo(
            cloneNode(this._termo_),
            cloneNode(this._mult_),
            cloneNode(this._expFinal_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMultTermo(this);
    }

    public PTermo getTermo()
    {
        return this._termo_;
    }

    public void setTermo(PTermo node)
    {
        if(this._termo_ != null)
        {
            this._termo_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._termo_ = node;
    }

    public TMult getMult()
    {
        return this._mult_;
    }

    public void setMult(TMult node)
    {
        if(this._mult_ != null)
        {
            this._mult_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._mult_ = node;
    }

    public PExpFinal getExpFinal()
    {
        return this._expFinal_;
    }

    public void setExpFinal(PExpFinal node)
    {
        if(this._expFinal_ != null)
        {
            this._expFinal_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expFinal_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._termo_)
            + toString(this._mult_)
            + toString(this._expFinal_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._termo_ == child)
        {
            this._termo_ = null;
            return;
        }

        if(this._mult_ == child)
        {
            this._mult_ = null;
            return;
        }

        if(this._expFinal_ == child)
        {
            this._expFinal_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._termo_ == oldChild)
        {
            setTermo((PTermo) newChild);
            return;
        }

        if(this._mult_ == oldChild)
        {
            setMult((TMult) newChild);
            return;
        }

        if(this._expFinal_ == oldChild)
        {
            setExpFinal((PExpFinal) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}