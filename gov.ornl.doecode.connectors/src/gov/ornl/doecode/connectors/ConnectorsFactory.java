/**
 */
package gov.ornl.doecode.connectors;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see gov.ornl.doecode.connectors.ConnectorsPackage
 * @generated
 */
public interface ConnectorsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ConnectorsFactory eINSTANCE = gov.ornl.doecode.connectors.impl.ConnectorsFactoryImpl.init();

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
	ConnectorsPackage getConnectorsPackage();

} //ConnectorsFactory
