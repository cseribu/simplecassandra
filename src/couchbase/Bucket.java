/**
 */
package couchbase;

import java.util.Map;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bucket</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link couchbase.Bucket#getName <em>Name</em>}</li>
 *   <li>{@link couchbase.Bucket#getDocuments <em>Documents</em>}</li>
 * </ul>
 * </p>
 *
 * @see couchbase.CouchbasePackage#getBucket()
 * @model
 * @generated
 */
public interface Bucket extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see couchbase.CouchbasePackage#getBucket_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link couchbase.Bucket#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Documents</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Documents</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Documents</em>' reference.
	 * @see #setDocuments(Map.Entry)
	 * @see couchbase.CouchbasePackage#getBucket_Documents()
	 * @model mapType="couchbase.EStirngToDocument<org.eclipse.emf.ecore.EString, couchbase.Document>"
	 * @generated
	 */
	Map.Entry<String, Document> getDocuments();

	/**
	 * Sets the value of the '{@link couchbase.Bucket#getDocuments <em>Documents</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Documents</em>' reference.
	 * @see #getDocuments()
	 * @generated
	 */
	void setDocuments(Map.Entry<String, Document> value);

} // Bucket
