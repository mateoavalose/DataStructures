package AA_ArbolClaseIsis;

public class NodoB<E extends Comparable<E>> {
	protected E llave;
	protected NodoB<E> hijoIzq;
	protected NodoB<E> hijoDer;
	
	protected NodoB<E> padre;

	public NodoB(E llave) {
		this.llave = llave;
		padre=null;
		hijoIzq=null;
		hijoDer=null;
	}

	public NodoB(E llave, NodoB<E> hijoIzq, NodoB<E> hijoDer, NodoB<E> padre) {
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


	public NodoB<E> getHijoIzq() {
		return hijoIzq;
	}


	public void setHijoIzq(NodoB<E> hijoIzq) {
		if (hijoIzq!=null){
			hijoIzq.setPadre(this);
		}
		this.hijoIzq = hijoIzq;
	}


	public NodoB<E> getHijoDer() {
		return hijoDer;
	}


	public void setHijoDer(NodoB<E> hijoDer) {
		if (hijoDer!=null){
			hijoDer.setPadre(this);
		}
		this.hijoDer = hijoDer;
	}

	public NodoB<E> getPadre() {
		return padre;
	}

	public void setPadre(NodoB<E> padre) {
		this.padre = padre;
	}


	
	
	
	
	
	
	
	
	
	
	public int getaltura() {
		return getaltura(this);
	}
	
	public int getaltura(NodoB<E> n) {
		if (n==null)
			return -1;
		int altder=getaltura(n.getHijoDer());
		int altizq=getaltura(n.getHijoIzq());
		return Math.max(altder, altizq)+1;
	}
	
	public int altura(){
		return altura(this);
	}
	
	public int altura (NodoB<E> n){
		if (n== null) return -1;
		int altder = (n.getHijoDer() == null? 0:1 + altura (n.getHijoDer()));
		int altizq = (n.getHijoIzq() == null? 0:1 + altura (n.getHijoIzq()));
		return Math.max(altder,altizq);
	}
	
	
	public int FE(){
		return altura(this.getHijoDer())-altura(this.getHijoIzq());
	}
	
	@Override
	public String toString() {
		String HI=(hijoIzq==null)? "null":hijoIzq.getLlave().toString();
		String HD=(hijoDer==null)? "null":hijoDer.getLlave().toString();
		return llave.toString()+ "("+HI+","+HD+")";
	}
}
