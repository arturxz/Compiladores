/* This file was generated by SableCC (http://www.sablecc.org/). */

package jah.analysis;

import java.util.*;
import jah.node.*;

public class AnalysisAdapter implements Analysis
{
    private Hashtable<Node,Object> in;
    private Hashtable<Node,Object> out;

    @Override
    public Object getIn(Node node)
    {
        if(this.in == null)
        {
            return null;
        }

        return this.in.get(node);
    }

    @Override
    public void setIn(Node node, Object o)
    {
        if(this.in == null)
        {
            this.in = new Hashtable<Node,Object>(1);
        }

        if(o != null)
        {
            this.in.put(node, o);
        }
        else
        {
            this.in.remove(node);
        }
    }

    @Override
    public Object getOut(Node node)
    {
        if(this.out == null)
        {
            return null;
        }

        return this.out.get(node);
    }

    @Override
    public void setOut(Node node, Object o)
    {
        if(this.out == null)
        {
            this.out = new Hashtable<Node,Object>(1);
        }

        if(o != null)
        {
            this.out.put(node, o);
        }
        else
        {
            this.out.remove(node);
        }
    }

    @Override
    public void caseStart(Start node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAPgr(APgr node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAVariavelDecl(AVariavelDecl node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAConstanteDecl(AConstanteDecl node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAComVirgulaPosDecl(AComVirgulaPosDecl node)
    {
        defaultCase(node);
    }

    @Override
    public void caseASemVirgulaPosDecl(ASemVirgulaPosDecl node)
    {
        defaultCase(node);
    }

    @Override
    public void caseARealTipo(ARealTipo node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAInteiroTipo(AInteiroTipo node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAStringTipo(AStringTipo node)
    {
        defaultCase(node);
    }

    @Override
    public void caseANormalVar(ANormalVar node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAArrayVar(AArrayVar node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAStringValor(AStringValor node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAInteiroValor(AInteiroValor node)
    {
        defaultCase(node);
    }

    @Override
    public void caseARealValor(ARealValor node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAApenasUmComandoMultiplosComm(AApenasUmComandoMultiplosComm node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMaisDeUmComandoMultiplosComm(AMaisDeUmComandoMultiplosComm node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAComandoNormalComm(AComandoNormalComm node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAComandoLeiaComm(AComandoLeiaComm node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAComandoEscrevaComm(AComandoEscrevaComm node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAComandoSeComm(AComandoSeComm node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAComandoAvalieComm(AComandoAvalieComm node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAComandoEnquantoComm(AComandoEnquantoComm node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAComandoRepitaComm(AComandoRepitaComm node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAComandoParaIteraComm(AComandoParaIteraComm node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAComandoParaPassaComm(AComandoParaPassaComm node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAFimSe(AFimSe node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAFimEnquanto(AFimEnquanto node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAInicioPara(AInicioPara node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAPassoPara(APassoPara node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAFimPara(AFimPara node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAFimSimplesFimAvalie(AFimSimplesFimAvalie node)
    {
        defaultCase(node);
    }

    @Override
    public void caseASennaoFimFimAvalie(ASennaoFimFimAvalie node)
    {
        defaultCase(node);
    }

    @Override
    public void caseADentroSeSimplesSeSenao(ADentroSeSimplesSeSenao node)
    {
        defaultCase(node);
    }

    @Override
    public void caseADentroSeSenaoSeSenao(ADentroSeSenaoSeSenao node)
    {
        defaultCase(node);
    }

    @Override
    public void caseACasoPosAvalie(ACasoPosAvalie node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAAvalieSimplesAvalieSenao(AAvalieSimplesAvalieSenao node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAAvalieSenaoAvalieSenao(AAvalieSenaoAvalieSenao node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAPosExp(APosExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAPosExplogica(APosExplogica node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAValorExp(AValorExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAExpEntreParentesisExp(AExpEntreParentesisExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAExpSomaExpExp(AExpSomaExpExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAExpSubExpExp(AExpSubExpExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAExpMulExpExp(AExpMulExpExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAExpDivExpExp(AExpDivExpExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAExplogicaExp(AExplogicaExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAExplogicaEntreParentesisExpLogica(AExplogicaEntreParentesisExpLogica node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAExpIgualaExpExpLogica(AExpIgualaExpExpLogica node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAExpDiferenteExpExpLogica(AExpDiferenteExpExpLogica node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAExpMenorIgualExpExpLogica(AExpMenorIgualExpExpLogica node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAExpMaiorIgualExpExpLogica(AExpMaiorIgualExpExpLogica node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAExpMenorExpExpLogica(AExpMenorExpExpLogica node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAExpMaiorExpExpLogica(AExpMaiorExpExpLogica node)
    {
        defaultCase(node);
    }

    @Override
    public void caseANaoExplogicaExpLogica(ANaoExplogicaExpLogica node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAExplogicaEExplogicaExpLogica(AExplogicaEExplogicaExpLogica node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAExplogicaOuExplogicaExpLogica(AExplogicaOuExplogicaExpLogica node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAExplogicaXorExplogicaExpLogica(AExplogicaXorExplogicaExpLogica node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAComVirgulaPosExpComm(AComVirgulaPosExpComm node)
    {
        defaultCase(node);
    }

    @Override
    public void caseASemVirgulaPosExpComm(ASemVirgulaPosExpComm node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTPrograma(TPrograma node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTInicio(TInicio node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTFim(TFim node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTFimPrograma(TFimPrograma node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTLeia(TLeia node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTEscreva(TEscreva node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTConstante(TConstante node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTFaca(TFaca node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTAte(TAte node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTDe(TDe node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTPasso(TPasso node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTSenao(TSenao node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTEntao(TEntao node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTSe(TSe node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTCaso(TCaso node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTAvalie(TAvalie node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTEnquanto(TEnquanto node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTPara(TPara node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTRepita(TRepita node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTSoma(TSoma node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTSub(TSub node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTMult(TMult node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTDiv(TDiv node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTMaior(TMaior node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTMenor(TMenor node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTIgual(TIgual node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTMaiorIgual(TMaiorIgual node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTMenorIgual(TMenorIgual node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTDiferente(TDiferente node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTNao(TNao node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTE(TE node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTOu(TOu node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTXor(TXor node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTTipoInteiro(TTipoInteiro node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTTipoReal(TTipoReal node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTTipoString(TTipoString node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTTipoBooleano(TTipoBooleano node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTVirgula(TVirgula node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTPonto(TPonto node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTPontoVirgula(TPontoVirgula node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTDoisPontos(TDoisPontos node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTAbreParentesis(TAbreParentesis node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTFechaParentesis(TFechaParentesis node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTAbreColchetes(TAbreColchetes node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTFechaColchetes(TFechaColchetes node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTAtribuicao(TAtribuicao node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTAspasSimples(TAspasSimples node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTAspasDuplas(TAspasDuplas node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTNovaLinha(TNovaLinha node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTTab(TTab node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTEspaco(TEspaco node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTInteiro(TInteiro node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTReal(TReal node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTString(TString node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTBooleano(TBooleano node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTId(TId node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTComentarioLinha(TComentarioLinha node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTComentarioBlocoAbre(TComentarioBlocoAbre node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTComentarioBlocoFecha(TComentarioBlocoFecha node)
    {
        defaultCase(node);
    }

    @Override
    public void caseEOF(EOF node)
    {
        defaultCase(node);
    }

    @Override
    public void caseInvalidToken(InvalidToken node)
    {
        defaultCase(node);
    }

    public void defaultCase(@SuppressWarnings("unused") Node node)
    {
        // do nothing
    }
}
