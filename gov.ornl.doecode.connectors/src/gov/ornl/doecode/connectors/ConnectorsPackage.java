/**
 */
package gov.ornl.doecode.connectors;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see gov.ornl.doecode.connectors.ConnectorsFactory
 * @model kind="package"
 * @generated
 */
public interface ConnectorsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "connectors";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "https://gov.ornl.doecode.connectors.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "gov.ornl.doecode.connectors";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ConnectorsPackage eINSTANCE = gov.ornl.doecode.connectors.impl.ConnectorsPackageImpl.init();

	/**
	 * The meta object id for the '{@link gov.ornl.doecode.connectors.impl.TestClassImpl <em>Test Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.ornl.doecode.connectors.impl.TestClassImpl
	 * @see gov.ornl.doecode.connectors.impl.ConnectorsPackageImpl#getTestClass()
	 * @generated
	 */
	int TEST_CLASS = 0;

	/**
	 * The number of structural features of the '<em>Test Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CLASS_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Test Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CLASS_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link gov.ornl.doecode.connectors.TestClass <em>Test Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Class</em>'.
	 * @see gov.ornl.doecode.connectors.TestClass
	 * @generated
	 */
	EClass getTestClass();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ConnectorsFactory getConnectorsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link gov.ornl.doecode.connectors.impl.TestClassImpl <em>Test Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.ornl.doecode.connectors.impl.TestClassImpl
		 * @see gov.ornl.doecode.connectors.impl.ConnectorsPackageImpl#getTestClass()
		 * @generated
		 */
		EClass TEST_CLASS = eINSTANCE.getTestClass();

	}

} //ConnectorsPackage
