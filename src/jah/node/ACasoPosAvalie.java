/* This file was generated by SableCC (http://www.sablecc.org/). */

package jah.node;

import jah.analysis.*;

@SuppressWarnings("nls")
public final class ACasoPosAvalie extends PPosAvalie
{
    private TCaso _caso_;
    private PValor _valor_;
    private TDoisPontos _doisPontos_;
    private PMultiplosComm _multiplosComm_;

    public ACasoPosAvalie()
    {
        // Constructor
    }

    public ACasoPosAvalie(
        @SuppressWarnings("hiding") TCaso _caso_,
        @SuppressWarnings("hiding") PValor _valor_,
        @SuppressWarnings("hiding") TDoisPontos _doisPontos_,
        @SuppressWarnings("hiding") PMultiplosComm _multiplosComm_)
    {
        // Constructor
        setCaso(_caso_);

        setValor(_valor_);

        setDoisPontos(_doisPontos_);

        setMultiplosComm(_multiplosComm_);

    }

    @Override
    public Object clone()
    {
        return new ACasoPosAvalie(
            cloneNode(this._caso_),
            cloneNode(this._valor_),
            cloneNode(this._doisPontos_),
            cloneNode(this._multiplosComm_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseACasoPosAvalie(this);
    }

    public TCaso getCaso()
    {
        return this._caso_;
    }

    public void setCaso(TCaso node)
    {
        if(this._caso_ != null)
        {
            this._caso_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._caso_ = node;
    }

    public PValor getValor()
    {
        return this._valor_;
    }

    public void setValor(PValor node)
    {
        if(this._valor_ != null)
        {
            this._valor_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._valor_ = node;
    }

    public TDoisPontos getDoisPontos()
    {
        return this._doisPontos_;
    }

    public void setDoisPontos(TDoisPontos node)
    {
        if(this._doisPontos_ != null)
        {
            this._doisPontos_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._doisPontos_ = node;
    }

    public PMultiplosComm getMultiplosComm()
    {
        return this._multiplosComm_;
    }

    public void setMultiplosComm(PMultiplosComm node)
    {
        if(this._multiplosComm_ != null)
        {
            this._multiplosComm_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._multiplosComm_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._caso_)
            + toString(this._valor_)
            + toString(this._doisPontos_)
            + toString(this._multiplosComm_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._caso_ == child)
        {
            this._caso_ = null;
            return;
        }

        if(this._valor_ == child)
        {
            this._valor_ = null;
            return;
        }

        if(this._doisPontos_ == child)
        {
            this._doisPontos_ = null;
            return;
        }

        if(this._multiplosComm_ == child)
        {
            this._multiplosComm_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._caso_ == oldChild)
        {
            setCaso((TCaso) newChild);
            return;
        }

        if(this._valor_ == oldChild)
        {
            setValor((PValor) newChild);
            return;
        }

        if(this._doisPontos_ == oldChild)
        {
            setDoisPontos((TDoisPontos) newChild);
            return;
        }

        if(this._multiplosComm_ == oldChild)
        {
            setMultiplosComm((PMultiplosComm) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
