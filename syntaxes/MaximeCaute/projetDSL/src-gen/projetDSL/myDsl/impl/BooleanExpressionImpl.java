/**
 * generated by Xtext 2.19.0
 */
package projetDSL.myDsl.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import projetDSL.myDsl.BooleanExpression;
import projetDSL.myDsl.MyDslPackage;
import projetDSL.myDsl.OperatorExpression;
import projetDSL.myDsl.Variable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Boolean Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link projetDSL.myDsl.impl.BooleanExpressionImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link projetDSL.myDsl.impl.BooleanExpressionImpl#getLeftMember <em>Left Member</em>}</li>
 *   <li>{@link projetDSL.myDsl.impl.BooleanExpressionImpl#getRightMember <em>Right Member</em>}</li>
 *   <li>{@link projetDSL.myDsl.impl.BooleanExpressionImpl#getNegatedMember <em>Negated Member</em>}</li>
 *   <li>{@link projetDSL.myDsl.impl.BooleanExpressionImpl#getVariable <em>Variable</em>}</li>
 *   <li>{@link projetDSL.myDsl.impl.BooleanExpressionImpl#getOperatorExpression <em>Operator Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BooleanExpressionImpl extends MinimalEObjectImpl.Container implements BooleanExpression
{
  /**
   * The cached value of the '{@link #getExpression() <em>Expression</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpression()
   * @generated
   * @ordered
   */
  protected EList<BooleanExpression> expression;

  /**
   * The cached value of the '{@link #getLeftMember() <em>Left Member</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLeftMember()
   * @generated
   * @ordered
   */
  protected EList<BooleanExpression> leftMember;

  /**
   * The cached value of the '{@link #getRightMember() <em>Right Member</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRightMember()
   * @generated
   * @ordered
   */
  protected EList<BooleanExpression> rightMember;

  /**
   * The cached value of the '{@link #getNegatedMember() <em>Negated Member</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNegatedMember()
   * @generated
   * @ordered
   */
  protected EList<BooleanExpression> negatedMember;

  /**
   * The cached value of the '{@link #getVariable() <em>Variable</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVariable()
   * @generated
   * @ordered
   */
  protected EList<Variable> variable;

  /**
   * The cached value of the '{@link #getOperatorExpression() <em>Operator Expression</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperatorExpression()
   * @generated
   * @ordered
   */
  protected EList<OperatorExpression> operatorExpression;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected BooleanExpressionImpl()
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
    return MyDslPackage.Literals.BOOLEAN_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<BooleanExpression> getExpression()
  {
    if (expression == null)
    {
      expression = new EObjectContainmentEList<BooleanExpression>(BooleanExpression.class, this, MyDslPackage.BOOLEAN_EXPRESSION__EXPRESSION);
    }
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<BooleanExpression> getLeftMember()
  {
    if (leftMember == null)
    {
      leftMember = new EObjectContainmentEList<BooleanExpression>(BooleanExpression.class, this, MyDslPackage.BOOLEAN_EXPRESSION__LEFT_MEMBER);
    }
    return leftMember;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<BooleanExpression> getRightMember()
  {
    if (rightMember == null)
    {
      rightMember = new EObjectContainmentEList<BooleanExpression>(BooleanExpression.class, this, MyDslPackage.BOOLEAN_EXPRESSION__RIGHT_MEMBER);
    }
    return rightMember;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<BooleanExpression> getNegatedMember()
  {
    if (negatedMember == null)
    {
      negatedMember = new EObjectContainmentEList<BooleanExpression>(BooleanExpression.class, this, MyDslPackage.BOOLEAN_EXPRESSION__NEGATED_MEMBER);
    }
    return negatedMember;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Variable> getVariable()
  {
    if (variable == null)
    {
      variable = new EObjectContainmentEList<Variable>(Variable.class, this, MyDslPackage.BOOLEAN_EXPRESSION__VARIABLE);
    }
    return variable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<OperatorExpression> getOperatorExpression()
  {
    if (operatorExpression == null)
    {
      operatorExpression = new EObjectContainmentEList<OperatorExpression>(OperatorExpression.class, this, MyDslPackage.BOOLEAN_EXPRESSION__OPERATOR_EXPRESSION);
    }
    return operatorExpression;
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
      case MyDslPackage.BOOLEAN_EXPRESSION__EXPRESSION:
        return ((InternalEList<?>)getExpression()).basicRemove(otherEnd, msgs);
      case MyDslPackage.BOOLEAN_EXPRESSION__LEFT_MEMBER:
        return ((InternalEList<?>)getLeftMember()).basicRemove(otherEnd, msgs);
      case MyDslPackage.BOOLEAN_EXPRESSION__RIGHT_MEMBER:
        return ((InternalEList<?>)getRightMember()).basicRemove(otherEnd, msgs);
      case MyDslPackage.BOOLEAN_EXPRESSION__NEGATED_MEMBER:
        return ((InternalEList<?>)getNegatedMember()).basicRemove(otherEnd, msgs);
      case MyDslPackage.BOOLEAN_EXPRESSION__VARIABLE:
        return ((InternalEList<?>)getVariable()).basicRemove(otherEnd, msgs);
      case MyDslPackage.BOOLEAN_EXPRESSION__OPERATOR_EXPRESSION:
        return ((InternalEList<?>)getOperatorExpression()).basicRemove(otherEnd, msgs);
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
      case MyDslPackage.BOOLEAN_EXPRESSION__EXPRESSION:
        return getExpression();
      case MyDslPackage.BOOLEAN_EXPRESSION__LEFT_MEMBER:
        return getLeftMember();
      case MyDslPackage.BOOLEAN_EXPRESSION__RIGHT_MEMBER:
        return getRightMember();
      case MyDslPackage.BOOLEAN_EXPRESSION__NEGATED_MEMBER:
        return getNegatedMember();
      case MyDslPackage.BOOLEAN_EXPRESSION__VARIABLE:
        return getVariable();
      case MyDslPackage.BOOLEAN_EXPRESSION__OPERATOR_EXPRESSION:
        return getOperatorExpression();
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
      case MyDslPackage.BOOLEAN_EXPRESSION__EXPRESSION:
        getExpression().clear();
        getExpression().addAll((Collection<? extends BooleanExpression>)newValue);
        return;
      case MyDslPackage.BOOLEAN_EXPRESSION__LEFT_MEMBER:
        getLeftMember().clear();
        getLeftMember().addAll((Collection<? extends BooleanExpression>)newValue);
        return;
      case MyDslPackage.BOOLEAN_EXPRESSION__RIGHT_MEMBER:
        getRightMember().clear();
        getRightMember().addAll((Collection<? extends BooleanExpression>)newValue);
        return;
      case MyDslPackage.BOOLEAN_EXPRESSION__NEGATED_MEMBER:
        getNegatedMember().clear();
        getNegatedMember().addAll((Collection<? extends BooleanExpression>)newValue);
        return;
      case MyDslPackage.BOOLEAN_EXPRESSION__VARIABLE:
        getVariable().clear();
        getVariable().addAll((Collection<? extends Variable>)newValue);
        return;
      case MyDslPackage.BOOLEAN_EXPRESSION__OPERATOR_EXPRESSION:
        getOperatorExpression().clear();
        getOperatorExpression().addAll((Collection<? extends OperatorExpression>)newValue);
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
      case MyDslPackage.BOOLEAN_EXPRESSION__EXPRESSION:
        getExpression().clear();
        return;
      case MyDslPackage.BOOLEAN_EXPRESSION__LEFT_MEMBER:
        getLeftMember().clear();
        return;
      case MyDslPackage.BOOLEAN_EXPRESSION__RIGHT_MEMBER:
        getRightMember().clear();
        return;
      case MyDslPackage.BOOLEAN_EXPRESSION__NEGATED_MEMBER:
        getNegatedMember().clear();
        return;
      case MyDslPackage.BOOLEAN_EXPRESSION__VARIABLE:
        getVariable().clear();
        return;
      case MyDslPackage.BOOLEAN_EXPRESSION__OPERATOR_EXPRESSION:
        getOperatorExpression().clear();
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
      case MyDslPackage.BOOLEAN_EXPRESSION__EXPRESSION:
        return expression != null && !expression.isEmpty();
      case MyDslPackage.BOOLEAN_EXPRESSION__LEFT_MEMBER:
        return leftMember != null && !leftMember.isEmpty();
      case MyDslPackage.BOOLEAN_EXPRESSION__RIGHT_MEMBER:
        return rightMember != null && !rightMember.isEmpty();
      case MyDslPackage.BOOLEAN_EXPRESSION__NEGATED_MEMBER:
        return negatedMember != null && !negatedMember.isEmpty();
      case MyDslPackage.BOOLEAN_EXPRESSION__VARIABLE:
        return variable != null && !variable.isEmpty();
      case MyDslPackage.BOOLEAN_EXPRESSION__OPERATOR_EXPRESSION:
        return operatorExpression != null && !operatorExpression.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //BooleanExpressionImpl