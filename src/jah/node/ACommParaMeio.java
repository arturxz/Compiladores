/* This file was generated by SableCC (http://www.sablecc.org/). */

package jah.node;

import jah.analysis.*;

@SuppressWarnings("nls")
public final class ACommParaMeio extends PCommParaMeio
{
    private TFaca _faca_;
    private PComandos _comandos_;
    private PCommParaFim _commParaFim_;

    public ACommParaMeio()
    {
        // Constructor
    }

    public ACommParaMeio(
        @SuppressWarnings("hiding") TFaca _faca_,
        @SuppressWarnings("hiding") PComandos _comandos_,
        @SuppressWarnings("hiding") PCommParaFim _commParaFim_)
    {
        // Constructor
        setFaca(_faca_);

        setComandos(_comandos_);

        setCommParaFim(_commParaFim_);

    }

    @Override
    public Object clone()
    {
        return new ACommParaMeio(
            cloneNode(this._faca_),
            cloneNode(this._comandos_),
            cloneNode(this._commParaFim_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseACommParaMeio(this);
    }

    public TFaca getFaca()
    {
        return this._faca_;
    }

    public void setFaca(TFaca node)
    {
        if(this._faca_ != null)
        {
            this._faca_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._faca_ = node;
    }

    public PComandos getComandos()
    {
        return this._comandos_;
    }

    public void setComandos(PComandos node)
    {
        if(this._comandos_ != null)
        {
            this._comandos_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._comandos_ = node;
    }

    public PCommParaFim getCommParaFim()
    {
        return this._commParaFim_;
    }

    public void setCommParaFim(PCommParaFim node)
    {
        if(this._commParaFim_ != null)
        {
            this._commParaFim_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._commParaFim_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._faca_)
            + toString(this._comandos_)
            + toString(this._commParaFim_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._faca_ == child)
        {
            this._faca_ = null;
            return;
        }

        if(this._comandos_ == child)
        {
            this._comandos_ = null;
            return;
        }

        if(this._commParaFim_ == child)
        {
            this._commParaFim_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._faca_ == oldChild)
        {
            setFaca((TFaca) newChild);
            return;
        }

        if(this._comandos_ == oldChild)
        {
            setComandos((PComandos) newChild);
            return;
        }

        if(this._commParaFim_ == oldChild)
        {
            setCommParaFim((PCommParaFim) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
