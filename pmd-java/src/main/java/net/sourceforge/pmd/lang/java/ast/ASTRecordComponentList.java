/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */


package net.sourceforge.pmd.lang.java.ast;

import java.util.Iterator;

import net.sourceforge.pmd.annotation.Experimental;

/**
 * Defines the state description of a {@linkplain ASTRecordDeclaration RecordDeclaration} (JDK 14 and JDK 15 preview feature).
 *
 * <pre class="grammar">
 *
 * RecordComponentList ::= "(" ( {@linkplain ASTRecordComponent RecordComponent} ( "," {@linkplain ASTRecordComponent RecordComponent} )* )? ")"
 *
 * </pre>
 */
@Experimental
public final class ASTRecordComponentList extends AbstractJavaNode implements Iterable<ASTRecordComponent> {
    ASTRecordComponentList(int id) {
        super(id);
    }

    @Override
    protected <P, R> R acceptVisitor(JavaVisitor<? super P, ? extends R> visitor, P data) {
        return visitor.visit(this, data);
    }

    public int size() {
        return getNumChildren();
    }

    @Override
    public Iterator<ASTRecordComponent> iterator() {
        return children(ASTRecordComponent.class).iterator();
    }
}
