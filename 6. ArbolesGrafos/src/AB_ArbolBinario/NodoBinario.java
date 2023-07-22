package AB_ArbolBinario;

public class NodoBinario <E extends Comparable<E>>{

	protected E llave;
	protected NodoBinario<E> hijoIzq;
	protected NodoBinario<E> hijoDer;
	protected NodoBinario<E> padre;

	public NodoBinario(E llave) {
		this.llave = llave;
		padre = null;
		hijoIzq = null;
		hijoDer = null;
	}

	public NodoBinario(E llave, NodoBinario<E> hijoIzq, NodoBinario<E> hijoDer, NodoBinario<E> padre) {
		super();
		this.llave = llave;
		this.hijoIzq = hijoIzq;
		this.hijoDer = hijoDer;
		this.padre = padre;
	}

	public E getLlave() {
		return llave;
	}

	public void setLlave(E llave) {
		this.llave = llave;
	}

	public NodoBinario<E> getHijoIzq() {
		return hijoIzq;
	}

	public void setHijoIzq(NodoBinario<E> hijoIzq) {
		if(hijoIzq != null)
			hijoIzq.setPadre(this);
		this.hijoIzq = hijoIzq;
	}

	public NodoBinario<E> getHijoDer() {
		return hijoDer;
	}

	public void setHijoDer(NodoBinario<E> hijoDer) {
		if(hijoDer != null)
			hijoDer.setPadre(this);
		this.hijoDer = hijoDer;
	}

	public NodoBinario<E> getPadre() {
		return padre;
	}

	public void setPadre(NodoBinario<E> padre) {
		this.padre = padre;
	}

	//Altura de nodo
	public int getAltura() {
		return getAltura(this);
	}
	public int getAltura(NodoBinario<E> nodo) {
		if(nodo == null) return -1;
		int altDer = getAltura(nodo.getHijoDer());
		int altIzq = getAltura(nodo.getHijoIzq());
		return Math.max(altDer, altIzq)+1;
	}
	
	public int altura() {
		return altura(this);
	}
	public int altura(NodoBinario<E> nodo) {
		if(nodo == null) return -1;
		int altDer = (nodo.getHijoDer()==null? 0:1 + altura(nodo.getHijoDer()));
		int altIzq = (nodo.getHijoIzq()==null? 0:1 + altura(nodo.getHijoIzq()));
		return Math.max(altDer, altIzq);
	}
	//Factor Equilibrio
	public int factorEquilibrio() {
		return altura(this.getHijoDer()) - altura(this.getHijoIzq());
	}
	@Override
	public String toString() {
		String HI = (hijoIzq == null)? "null":hijoIzq.getLlave().toString();
		String HD = (hijoDer == null)? "null":hijoDer.getLlave().toString();
		return llave.toString() + "(" + HI + "," + HD + ")";
	}
}
