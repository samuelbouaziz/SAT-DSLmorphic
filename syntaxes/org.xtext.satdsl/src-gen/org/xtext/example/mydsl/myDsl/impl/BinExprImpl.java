/**
 * generated by Xtext 2.19.0
 */
package org.xtext.example.mydsl.myDsl.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.xtext.example.mydsl.myDsl.BinExpr;
import org.xtext.example.mydsl.myDsl.Expression;
import org.xtext.example.mydsl.myDsl.MyDslPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bin Expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.impl.BinExprImpl#getLeftexpr <em>Leftexpr</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.impl.BinExprImpl#getOp <em>Op</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.impl.BinExprImpl#getRightexpr <em>Rightexpr</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BinExprImpl extends MinimalEObjectImpl.Container implements BinExpr
{
  /**
   * The cached value of the '{@link #getLeftexpr() <em>Leftexpr</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLeftexpr()
   * @generated
   * @ordered
   */
  protected EList<Expression> leftexpr;

  /**
   * The cached value of the '{@link #getOp() <em>Op</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOp()
   * @generated
   * @ordered
   */
  protected EList<String> op;

  /**
   * The cached value of the '{@link #getRightexpr() <em>Rightexpr</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRightexpr()
   * @generated
   * @ordered
   */
  protected EList<Expression> rightexpr;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected BinExprImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return MyDslPackage.Literals.BIN_EXPR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Expression> getLeftexpr()
  {
    if (leftexpr == null)
    {
      leftexpr = new EObjectContainmentEList<Expression>(Expression.class, this, MyDslPackage.BIN_EXPR__LEFTEXPR);
    }
    return leftexpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<String> getOp()
  {
    if (op == null)
    {
      op = new EDataTypeEList<String>(String.class, this, MyDslPackage.BIN_EXPR__OP);
    }
    return op;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Expression> getRightexpr()
  {
    if (rightexpr == null)
    {
      rightexpr = new EObjectContainmentEList<Expression>(Expression.class, this, MyDslPackage.BIN_EXPR__RIGHTEXPR);
    }
    return rightexpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case MyDslPackage.BIN_EXPR__LEFTEXPR:
        return ((InternalEList<?>)getLeftexpr()).basicRemove(otherEnd, msgs);
      case MyDslPackage.BIN_EXPR__RIGHTEXPR:
        return ((InternalEList<?>)getRightexpr()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case MyDslPackage.BIN_EXPR__LEFTEXPR:
        return getLeftexpr();
      case MyDslPackage.BIN_EXPR__OP:
        return getOp();
      case MyDslPackage.BIN_EXPR__RIGHTEXPR:
        return getRightexpr();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case MyDslPackage.BIN_EXPR__LEFTEXPR:
        getLeftexpr().clear();
        getLeftexpr().addAll((Collection<? extends Expression>)newValue);
        return;
      case MyDslPackage.BIN_EXPR__OP:
        getOp().clear();
        getOp().addAll((Collection<? extends String>)newValue);
        return;
      case MyDslPackage.BIN_EXPR__RIGHTEXPR:
        getRightexpr().clear();
        getRightexpr().addAll((Collection<? extends Expression>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case MyDslPackage.BIN_EXPR__LEFTEXPR:
        getLeftexpr().clear();
        return;
      case MyDslPackage.BIN_EXPR__OP:
        getOp().clear();
        return;
      case MyDslPackage.BIN_EXPR__RIGHTEXPR:
        getRightexpr().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case MyDslPackage.BIN_EXPR__LEFTEXPR:
        return leftexpr != null && !leftexpr.isEmpty();
      case MyDslPackage.BIN_EXPR__OP:
        return op != null && !op.isEmpty();
      case MyDslPackage.BIN_EXPR__RIGHTEXPR:
        return rightexpr != null && !rightexpr.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (op: ");
    result.append(op);
    result.append(')');
    return result.toString();
  }

} //BinExprImpl
