/**
 */
package cassandra;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * <!-- begin-model-doc -->
 *  Keyspaces are quite simple, from an RDBMS point of view you can compare this to your schema, normally you have one per application. A keyspace contains the ColumnFamilies. 
 * <!-- end-model-doc -->
 * @see cassandra.CassandraFactory
 * @model kind="package"
 * @generated
 */
public interface CassandraPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "cassandra";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://cass/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "cassandra";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CassandraPackage eINSTANCE = cassandra.impl.CassandraPackageImpl.init();

	/**
	 * The meta object id for the '{@link cassandra.impl.KeyspaceImpl <em>Keyspace</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cassandra.impl.KeyspaceImpl
	 * @see cassandra.impl.CassandraPackageImpl#getKeyspace()
	 * @generated
	 */
	int KEYSPACE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEYSPACE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Columnfamilies</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEYSPACE__COLUMNFAMILIES = 1;

	/**
	 * The number of structural features of the '<em>Keyspace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEYSPACE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Keyspace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEYSPACE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link cassandra.impl.ColumnFamilyImpl <em>Column Family</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cassandra.impl.ColumnFamilyImpl
	 * @see cassandra.impl.CassandraPackageImpl#getColumnFamily()
	 * @generated
	 */
	int COLUMN_FAMILY = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN_FAMILY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Rows</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN_FAMILY__ROWS = 1;

	/**
	 * The number of structural features of the '<em>Column Family</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN_FAMILY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Column Family</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN_FAMILY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link cassandra.impl.RowImpl <em>Row</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cassandra.impl.RowImpl
	 * @see cassandra.impl.CassandraPackageImpl#getRow()
	 * @generated
	 */
	int ROW = 2;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROW__KEY = 0;

	/**
	 * The feature id for the '<em><b>Columns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROW__COLUMNS = 1;

	/**
	 * The feature id for the '<em><b>Supercolumns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROW__SUPERCOLUMNS = 2;

	/**
	 * The number of structural features of the '<em>Row</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROW_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Row</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROW_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link cassandra.impl.ColumnImpl <em>Column</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cassandra.impl.ColumnImpl
	 * @see cassandra.impl.CassandraPackageImpl#getColumn()
	 * @generated
	 */
	int COLUMN = 3;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN__VALUE = 1;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN__TIMESTAMP = 2;

	/**
	 * The number of structural features of the '<em>Column</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Column</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link cassandra.impl.SuperColumnImpl <em>Super Column</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cassandra.impl.SuperColumnImpl
	 * @see cassandra.impl.CassandraPackageImpl#getSuperColumn()
	 * @generated
	 */
	int SUPER_COLUMN = 4;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPER_COLUMN__KEY = 0;

	/**
	 * The feature id for the '<em><b>Columns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPER_COLUMN__COLUMNS = 1;

	/**
	 * The number of structural features of the '<em>Super Column</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPER_COLUMN_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Super Column</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPER_COLUMN_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '<em>Timestamp</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.sql.Timestamp
	 * @see cassandra.impl.CassandraPackageImpl#getTimestamp()
	 * @generated
	 */
	int TIMESTAMP = 5;

	/**
	 * The meta object id for the '<em>Bytes Type</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.sql.Blob
	 * @see cassandra.impl.CassandraPackageImpl#getBytesType()
	 * @generated
	 */
	int BYTES_TYPE = 6;

	/**
	 * The meta object id for the '<em>Decimal Type</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.math.BigDecimal
	 * @see cassandra.impl.CassandraPackageImpl#getDecimalType()
	 * @generated
	 */
	int DECIMAL_TYPE = 7;

	/**
	 * The meta object id for the '<em>UTF8 Type</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see cassandra.impl.CassandraPackageImpl#getUTF8Type()
	 * @generated
	 */
	int UTF8_TYPE = 8;

	/**
	 * The meta object id for the '<em>Double Type</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Double
	 * @see cassandra.impl.CassandraPackageImpl#getDoubleType()
	 * @generated
	 */
	int DOUBLE_TYPE = 9;

	/**
	 * The meta object id for the '<em>Int32 Type</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Integer
	 * @see cassandra.impl.CassandraPackageImpl#getInt32Type()
	 * @generated
	 */
	int INT32_TYPE = 10;

	/**
	 * The meta object id for the '<em>Ascii Type</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see cassandra.impl.CassandraPackageImpl#getAsciiType()
	 * @generated
	 */
	int ASCII_TYPE = 11;

	/**
	 * The meta object id for the '<em>UUID Type</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see cassandra.impl.CassandraPackageImpl#getUUIDType()
	 * @generated
	 */
	int UUID_TYPE = 12;

	/**
	 * The meta object id for the '<em>Boolean Type</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Boolean
	 * @see cassandra.impl.CassandraPackageImpl#getBooleanType()
	 * @generated
	 */
	int BOOLEAN_TYPE = 13;

	/**
	 * The meta object id for the '<em>Float Type</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Float
	 * @see cassandra.impl.CassandraPackageImpl#getFloatType()
	 * @generated
	 */
	int FLOAT_TYPE = 14;

	/**
	 * The meta object id for the '<em>Date Type</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.sql.Date
	 * @see cassandra.impl.CassandraPackageImpl#getDateType()
	 * @generated
	 */
	int DATE_TYPE = 15;

	/**
	 * The meta object id for the '<em>Counter Column Type</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Long
	 * @see cassandra.impl.CassandraPackageImpl#getCounterColumnType()
	 * @generated
	 */
	int COUNTER_COLUMN_TYPE = 16;

	/**
	 * Returns the meta object for class '{@link cassandra.Keyspace <em>Keyspace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Keyspace</em>'.
	 * @see cassandra.Keyspace
	 * @generated
	 */
	EClass getKeyspace();

	/**
	 * Returns the meta object for the attribute '{@link cassandra.Keyspace#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see cassandra.Keyspace#getName()
	 * @see #getKeyspace()
	 * @generated
	 */
	EAttribute getKeyspace_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link cassandra.Keyspace#getColumnfamilies <em>Columnfamilies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Columnfamilies</em>'.
	 * @see cassandra.Keyspace#getColumnfamilies()
	 * @see #getKeyspace()
	 * @generated
	 */
	EReference getKeyspace_Columnfamilies();

	/**
	 * Returns the meta object for class '{@link cassandra.ColumnFamily <em>Column Family</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Column Family</em>'.
	 * @see cassandra.ColumnFamily
	 * @generated
	 */
	EClass getColumnFamily();

	/**
	 * Returns the meta object for the attribute '{@link cassandra.ColumnFamily#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see cassandra.ColumnFamily#getName()
	 * @see #getColumnFamily()
	 * @generated
	 */
	EAttribute getColumnFamily_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link cassandra.ColumnFamily#getRows <em>Rows</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rows</em>'.
	 * @see cassandra.ColumnFamily#getRows()
	 * @see #getColumnFamily()
	 * @generated
	 */
	EReference getColumnFamily_Rows();

	/**
	 * Returns the meta object for class '{@link cassandra.Row <em>Row</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Row</em>'.
	 * @see cassandra.Row
	 * @generated
	 */
	EClass getRow();

	/**
	 * Returns the meta object for the attribute '{@link cassandra.Row#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see cassandra.Row#getKey()
	 * @see #getRow()
	 * @generated
	 */
	EAttribute getRow_Key();

	/**
	 * Returns the meta object for the containment reference list '{@link cassandra.Row#getColumns <em>Columns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Columns</em>'.
	 * @see cassandra.Row#getColumns()
	 * @see #getRow()
	 * @generated
	 */
	EReference getRow_Columns();

	/**
	 * Returns the meta object for the containment reference list '{@link cassandra.Row#getSupercolumns <em>Supercolumns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Supercolumns</em>'.
	 * @see cassandra.Row#getSupercolumns()
	 * @see #getRow()
	 * @generated
	 */
	EReference getRow_Supercolumns();

	/**
	 * Returns the meta object for class '{@link cassandra.Column <em>Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Column</em>'.
	 * @see cassandra.Column
	 * @generated
	 */
	EClass getColumn();

	/**
	 * Returns the meta object for the attribute '{@link cassandra.Column#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see cassandra.Column#getKey()
	 * @see #getColumn()
	 * @generated
	 */
	EAttribute getColumn_Key();

	/**
	 * Returns the meta object for the attribute '{@link cassandra.Column#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see cassandra.Column#getValue()
	 * @see #getColumn()
	 * @generated
	 */
	EAttribute getColumn_Value();

	/**
	 * Returns the meta object for the attribute '{@link cassandra.Column#getTimestamp <em>Timestamp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Timestamp</em>'.
	 * @see cassandra.Column#getTimestamp()
	 * @see #getColumn()
	 * @generated
	 */
	EAttribute getColumn_Timestamp();

	/**
	 * Returns the meta object for class '{@link cassandra.SuperColumn <em>Super Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Super Column</em>'.
	 * @see cassandra.SuperColumn
	 * @generated
	 */
	EClass getSuperColumn();

	/**
	 * Returns the meta object for the attribute '{@link cassandra.SuperColumn#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see cassandra.SuperColumn#getKey()
	 * @see #getSuperColumn()
	 * @generated
	 */
	EAttribute getSuperColumn_Key();

	/**
	 * Returns the meta object for the containment reference list '{@link cassandra.SuperColumn#getColumns <em>Columns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Columns</em>'.
	 * @see cassandra.SuperColumn#getColumns()
	 * @see #getSuperColumn()
	 * @generated
	 */
	EReference getSuperColumn_Columns();

	/**
	 * Returns the meta object for data type '{@link java.sql.Timestamp <em>Timestamp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Timestamp</em>'.
	 * @see java.sql.Timestamp
	 * @model instanceClass="java.sql.Timestamp"
	 * @generated
	 */
	EDataType getTimestamp();

	/**
	 * Returns the meta object for data type '{@link java.sql.Blob <em>Bytes Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Bytes Type</em>'.
	 * @see java.sql.Blob
	 * @model instanceClass="java.sql.Blob"
	 * @generated
	 */
	EDataType getBytesType();

	/**
	 * Returns the meta object for data type '{@link java.math.BigDecimal <em>Decimal Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Decimal Type</em>'.
	 * @see java.math.BigDecimal
	 * @model instanceClass="java.math.BigDecimal"
	 * @generated
	 */
	EDataType getDecimalType();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>UTF8 Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>UTF8 Type</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getUTF8Type();

	/**
	 * Returns the meta object for data type '{@link java.lang.Double <em>Double Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Double Type</em>'.
	 * @see java.lang.Double
	 * @model instanceClass="java.lang.Double"
	 * @generated
	 */
	EDataType getDoubleType();

	/**
	 * Returns the meta object for data type '{@link java.lang.Integer <em>Int32 Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Int32 Type</em>'.
	 * @see java.lang.Integer
	 * @model instanceClass="java.lang.Integer"
	 * @generated
	 */
	EDataType getInt32Type();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Ascii Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Ascii Type</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getAsciiType();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>UUID Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>UUID Type</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getUUIDType();

	/**
	 * Returns the meta object for data type '{@link java.lang.Boolean <em>Boolean Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Boolean Type</em>'.
	 * @see java.lang.Boolean
	 * @model instanceClass="java.lang.Boolean"
	 * @generated
	 */
	EDataType getBooleanType();

	/**
	 * Returns the meta object for data type '{@link java.lang.Float <em>Float Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Float Type</em>'.
	 * @see java.lang.Float
	 * @model instanceClass="java.lang.Float"
	 * @generated
	 */
	EDataType getFloatType();

	/**
	 * Returns the meta object for data type '{@link java.sql.Date <em>Date Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Date Type</em>'.
	 * @see java.sql.Date
	 * @model instanceClass="java.sql.Date"
	 * @generated
	 */
	EDataType getDateType();

	/**
	 * Returns the meta object for data type '{@link java.lang.Long <em>Counter Column Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Counter Column Type</em>'.
	 * @see java.lang.Long
	 * @model instanceClass="java.lang.Long"
	 * @generated
	 */
	EDataType getCounterColumnType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CassandraFactory getCassandraFactory();

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
		 * The meta object literal for the '{@link cassandra.impl.KeyspaceImpl <em>Keyspace</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cassandra.impl.KeyspaceImpl
		 * @see cassandra.impl.CassandraPackageImpl#getKeyspace()
		 * @generated
		 */
		EClass KEYSPACE = eINSTANCE.getKeyspace();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KEYSPACE__NAME = eINSTANCE.getKeyspace_Name();

		/**
		 * The meta object literal for the '<em><b>Columnfamilies</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KEYSPACE__COLUMNFAMILIES = eINSTANCE.getKeyspace_Columnfamilies();

		/**
		 * The meta object literal for the '{@link cassandra.impl.ColumnFamilyImpl <em>Column Family</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cassandra.impl.ColumnFamilyImpl
		 * @see cassandra.impl.CassandraPackageImpl#getColumnFamily()
		 * @generated
		 */
		EClass COLUMN_FAMILY = eINSTANCE.getColumnFamily();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLUMN_FAMILY__NAME = eINSTANCE.getColumnFamily_Name();

		/**
		 * The meta object literal for the '<em><b>Rows</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLUMN_FAMILY__ROWS = eINSTANCE.getColumnFamily_Rows();

		/**
		 * The meta object literal for the '{@link cassandra.impl.RowImpl <em>Row</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cassandra.impl.RowImpl
		 * @see cassandra.impl.CassandraPackageImpl#getRow()
		 * @generated
		 */
		EClass ROW = eINSTANCE.getRow();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROW__KEY = eINSTANCE.getRow_Key();

		/**
		 * The meta object literal for the '<em><b>Columns</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROW__COLUMNS = eINSTANCE.getRow_Columns();

		/**
		 * The meta object literal for the '<em><b>Supercolumns</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROW__SUPERCOLUMNS = eINSTANCE.getRow_Supercolumns();

		/**
		 * The meta object literal for the '{@link cassandra.impl.ColumnImpl <em>Column</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cassandra.impl.ColumnImpl
		 * @see cassandra.impl.CassandraPackageImpl#getColumn()
		 * @generated
		 */
		EClass COLUMN = eINSTANCE.getColumn();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLUMN__KEY = eINSTANCE.getColumn_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLUMN__VALUE = eINSTANCE.getColumn_Value();

		/**
		 * The meta object literal for the '<em><b>Timestamp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLUMN__TIMESTAMP = eINSTANCE.getColumn_Timestamp();

		/**
		 * The meta object literal for the '{@link cassandra.impl.SuperColumnImpl <em>Super Column</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cassandra.impl.SuperColumnImpl
		 * @see cassandra.impl.CassandraPackageImpl#getSuperColumn()
		 * @generated
		 */
		EClass SUPER_COLUMN = eINSTANCE.getSuperColumn();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUPER_COLUMN__KEY = eINSTANCE.getSuperColumn_Key();

		/**
		 * The meta object literal for the '<em><b>Columns</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUPER_COLUMN__COLUMNS = eINSTANCE.getSuperColumn_Columns();

		/**
		 * The meta object literal for the '<em>Timestamp</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.sql.Timestamp
		 * @see cassandra.impl.CassandraPackageImpl#getTimestamp()
		 * @generated
		 */
		EDataType TIMESTAMP = eINSTANCE.getTimestamp();

		/**
		 * The meta object literal for the '<em>Bytes Type</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.sql.Blob
		 * @see cassandra.impl.CassandraPackageImpl#getBytesType()
		 * @generated
		 */
		EDataType BYTES_TYPE = eINSTANCE.getBytesType();

		/**
		 * The meta object literal for the '<em>Decimal Type</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.math.BigDecimal
		 * @see cassandra.impl.CassandraPackageImpl#getDecimalType()
		 * @generated
		 */
		EDataType DECIMAL_TYPE = eINSTANCE.getDecimalType();

		/**
		 * The meta object literal for the '<em>UTF8 Type</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see cassandra.impl.CassandraPackageImpl#getUTF8Type()
		 * @generated
		 */
		EDataType UTF8_TYPE = eINSTANCE.getUTF8Type();

		/**
		 * The meta object literal for the '<em>Double Type</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Double
		 * @see cassandra.impl.CassandraPackageImpl#getDoubleType()
		 * @generated
		 */
		EDataType DOUBLE_TYPE = eINSTANCE.getDoubleType();

		/**
		 * The meta object literal for the '<em>Int32 Type</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Integer
		 * @see cassandra.impl.CassandraPackageImpl#getInt32Type()
		 * @generated
		 */
		EDataType INT32_TYPE = eINSTANCE.getInt32Type();

		/**
		 * The meta object literal for the '<em>Ascii Type</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see cassandra.impl.CassandraPackageImpl#getAsciiType()
		 * @generated
		 */
		EDataType ASCII_TYPE = eINSTANCE.getAsciiType();

		/**
		 * The meta object literal for the '<em>UUID Type</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see cassandra.impl.CassandraPackageImpl#getUUIDType()
		 * @generated
		 */
		EDataType UUID_TYPE = eINSTANCE.getUUIDType();

		/**
		 * The meta object literal for the '<em>Boolean Type</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Boolean
		 * @see cassandra.impl.CassandraPackageImpl#getBooleanType()
		 * @generated
		 */
		EDataType BOOLEAN_TYPE = eINSTANCE.getBooleanType();

		/**
		 * The meta object literal for the '<em>Float Type</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Float
		 * @see cassandra.impl.CassandraPackageImpl#getFloatType()
		 * @generated
		 */
		EDataType FLOAT_TYPE = eINSTANCE.getFloatType();

		/**
		 * The meta object literal for the '<em>Date Type</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.sql.Date
		 * @see cassandra.impl.CassandraPackageImpl#getDateType()
		 * @generated
		 */
		EDataType DATE_TYPE = eINSTANCE.getDateType();

		/**
		 * The meta object literal for the '<em>Counter Column Type</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Long
		 * @see cassandra.impl.CassandraPackageImpl#getCounterColumnType()
		 * @generated
		 */
		EDataType COUNTER_COLUMN_TYPE = eINSTANCE.getCounterColumnType();

	}

} //CassandraPackage
