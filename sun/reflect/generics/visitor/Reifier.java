package sun.reflect.generics.visitor;

import sun.reflect.generics.factory.GenericsFactory;
import sun.reflect.generics.tree.*;

import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;

public class Reifier implements TypeTreeVisitor<Type> {

    private Type resultType;

    private GenericsFactory factory;

    private Reifier(GenericsFactory f) {
        factory = f;
    }

    private GenericsFactory getFactory() {
        return factory;
    }

    public static Reifier make(GenericsFactory f) {
        return new Reifier(f);
    }

    private Type[] reifyTypeArguments(TypeArgument[] tas) {
        Type[] ts = new Type[tas.length];
        for (int i = 0; i < tas.length; i++) {
            tas[i].accept(this);
            ts[i] = resultType;
        }
        return ts;
    }

    public Type getResult() {
        assert resultType != null;
        return resultType;
    }

    public void visitArrayTypeSignature(ArrayTypeSignature a) {
        a.getComponentType().accept(this);
        Type ct = resultType;
        resultType = getFactory().makeArrayType(ct);
    }

    public void visitFormalTypeParameter(FormalTypeParameter ftp) {
        resultType = getFactory().makeTypeVariable(ftp.getName(), ftp.getBounds());
    }

    public void visitClassTypeSignature(ClassTypeSignature ct) {
        List<SimpleClassTypeSignature> scts = ct.getPath();
        assert (!scts.isEmpty());
        Iterator<SimpleClassTypeSignature> iter = scts.iterator();
        SimpleClassTypeSignature sc = iter.next();
        StringBuilder n = new StringBuilder(sc.getName());
        boolean dollar = sc.getDollar();
    }

    public void visitTypeVariableSignature(TypeVariableSignature tv){
        resultType = getFactory().findTypeVariable(tv.getIdentifier());
    }

    public void visitWildcard(Wildcard w){
        resultType = getFactory().makeWildcard(w.getUpperBounds(),
                w.getLowerBounds());
    }

    public void visitSimpleClassTypeSignature(SimpleClassTypeSignature sct){
        resultType = getFactory().makeNamedType(sct.getName());
    }

    public void visitBottomSignature(BottomSignature b){

    }

    public void visitByteSignature(ByteSignature b){
        resultType = getFactory().makeByte();
    }

    public void visitBooleanSignature(BooleanSignature b){
        resultType = getFactory().makeBool();
    }

    public void visitShortSignature(ShortSignature s){
        resultType = getFactory().makeShort();
    }

    public void visitCharSignature(CharSignature c){
        resultType = getFactory().makeChar();
    }

    public void visitIntSignature(IntSignature i){
        resultType = getFactory().makeInt();
    }

    public void visitLongSignature(LongSignature l){
        resultType = getFactory().makeLong();
    }

    public void visitFloatSignature(FloatSignature f){
        resultType = getFactory().makeFloat();
    }

    public void visitDoubleSignature(DoubleSignature d){
        resultType = getFactory().makeDouble();
    }

    public void visitVoidDescriptor(VoidDescriptor v){
        resultType = getFactory().makeVoid();
    }
}
