/* This file was generated by SableCC (http://www.sablecc.org/). */

package jah.node;

import jah.analysis.*;

@SuppressWarnings("nls")
public final class ACommPara extends PCommPara
{
    private TPara _para_;
    private PVar _var_;
    private TDe _de_;
    private TInteiro _inteiro_;
    private PCommParaPassa _commParaPassa_;

    public ACommPara()
    {
        // Constructor
    }

    public ACommPara(
        @SuppressWarnings("hiding") TPara _para_,
        @SuppressWarnings("hiding") PVar _var_,
        @SuppressWarnings("hiding") TDe _de_,
        @SuppressWarnings("hiding") TInteiro _inteiro_,
        @SuppressWarnings("hiding") PCommParaPassa _commParaPassa_)
    {
        // Constructor
        setPara(_para_);

        setVar(_var_);

        setDe(_de_);

        setInteiro(_inteiro_);

        setCommParaPassa(_commParaPassa_);

    }

    @Override
    public Object clone()
    {
        return new ACommPara(
            cloneNode(this._para_),
            cloneNode(this._var_),
            cloneNode(this._de_),
            cloneNode(this._inteiro_),
            cloneNode(this._commParaPassa_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseACommPara(this);
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

    public PVar getVar()
    {
        return this._var_;
    }

    public void setVar(PVar node)
    {
        if(this._var_ != null)
        {
            this._var_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._var_ = node;
    }

    public TDe getDe()
    {
        return this._de_;
    }

    public void setDe(TDe node)
    {
        if(this._de_ != null)
        {
            this._de_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._de_ = node;
    }

    public TInteiro getInteiro()
    {
        return this._inteiro_;
    }

    public void setInteiro(TInteiro node)
    {
        if(this._inteiro_ != null)
        {
            this._inteiro_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._inteiro_ = node;
    }

    public PCommParaPassa getCommParaPassa()
    {
        return this._commParaPassa_;
    }

    public void setCommParaPassa(PCommParaPassa node)
    {
        if(this._commParaPassa_ != null)
        {
            this._commParaPassa_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._commParaPassa_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._para_)
            + toString(this._var_)
            + toString(this._de_)
            + toString(this._inteiro_)
            + toString(this._commParaPassa_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._para_ == child)
        {
            this._para_ = null;
            return;
        }

        if(this._var_ == child)
        {
            this._var_ = null;
            return;
        }

        if(this._de_ == child)
        {
            this._de_ = null;
            return;
        }

        if(this._inteiro_ == child)
        {
            this._inteiro_ = null;
            return;
        }

        if(this._commParaPassa_ == child)
        {
            this._commParaPassa_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._para_ == oldChild)
        {
            setPara((TPara) newChild);
            return;
        }

        if(this._var_ == oldChild)
        {
            setVar((PVar) newChild);
            return;
        }

        if(this._de_ == oldChild)
        {
            setDe((TDe) newChild);
            return;
        }

        if(this._inteiro_ == oldChild)
        {
            setInteiro((TInteiro) newChild);
            return;
        }

        if(this._commParaPassa_ == oldChild)
        {
            setCommParaPassa((PCommParaPassa) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}