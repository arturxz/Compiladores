/* This file was generated by SableCC (http://www.sablecc.org/). */

package jah.node;

import jah.analysis.*;

@SuppressWarnings("nls")
public final class AFimPara extends PFimPara
{
    private TFim _fim_;
    private TPara _para_;

    public AFimPara()
    {
        // Constructor
    }

    public AFimPara(
        @SuppressWarnings("hiding") TFim _fim_,
        @SuppressWarnings("hiding") TPara _para_)
    {
        // Constructor
        setFim(_fim_);

        setPara(_para_);

    }

    @Override
    public Object clone()
    {
        return new AFimPara(
            cloneNode(this._fim_),
            cloneNode(this._para_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAFimPara(this);
    }

    public TFim getFim()
    {
        return this._fim_;
    }

    public void setFim(TFim node)
    {
        if(this._fim_ != null)
        {
            this._fim_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._fim_ = node;
    }

    public TPara getPara()
    {
        return this._para_;
    }

    public void setPara(TPara node)
    {
        if(this._para_ != null)
        {
            this._para_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._para_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._fim_)
            + toString(this._para_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._fim_ == child)
        {
            this._fim_ = null;
            return;
        }

        if(this._para_ == child)
        {
            this._para_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._fim_ == oldChild)
        {
            setFim((TFim) newChild);
            return;
        }

        if(this._para_ == oldChild)
        {
            setPara((TPara) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
