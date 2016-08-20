/**
 */
package gov.ornl.doecode;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see gov.ornl.doecode.DoecodePackage
 * @generated
 */
public interface DoecodeFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DoecodeFactory eINSTANCE = gov.ornl.doecode.impl.DoecodeFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Test Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Test Class</em>'.
	 * @generated
	 */
	TestClass createTestClass();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DoecodePackage getDoecodePackage();

} //DoecodeFactory
