# Employee Management System - DDD Project

## Project Overview
This is a complete Domain-Driven Design (DDD) implementation of an Employee Management System with 8 entities and full CRUD operations. The project follows clean architecture principles with separation of concerns across multiple layers.

## Project Structure

### Packages Overview

#### 1. **Domain Package** (`za.ac.cput.domain`)
Contains 8 entity classes representing the core business domain:

- **Employee.java** - Main employee entity with personal and employment details
  - Fields: employeeId, firstName, lastName, dateOfBirth, email, hireDate, departmentId, positionId, addressId, contactId
  
- **Department.java** - Department information
  - Fields: departmentId, departmentName, description, managerId
  
- **Position.java** - Job position details
  - Fields: positionId, positionTitle, description, baseSalary
  
- **Address.java** - Employee address information
  - Fields: addressId, street, city, province, zipCode, country
  
- **Contact.java** - Contact information
  - Fields: contactId, phoneNumber, cellPhone, emergencyContact, emergencyPhoneNumber
  
- **Salary.java** - Salary and compensation details
  - Fields: salaryId, employeeId, baseSalary, bonus, deductions, effectiveDate
  - Method: calculateNetSalary()
  
- **Leave.java** - Employee leave records
  - Fields: leaveId, employeeId, leaveType, startDate, endDate, status, reason
  - Method: calculateDays()
  
- **EmployeePerformance.java** - Performance review records
  - Fields: performanceId, employeeId, rating, feedback, reviewDate, reviewerName
  - Method: getPerformanceLevel()

#### 2. **Factory Package** (`za.ac.cput.factory`)
Contains factory classes for creating entities with validation:

- **EmployeeFactory.java**
- **DepartmentFactory.java**
- **PositionFactory.java**
- **AddressFactory.java**
- **ContactFactory.java**
- **SalaryFactory.java**
- **LeaveFactory.java**
- **EmployeePerformanceFactory.java**

Each factory validates required fields and provides both full and empty constructors.

#### 3. **Repository Package** (`za.ac.cput.repository`)
Contains repository interfaces and implementations for data access:

**Interfaces:**
- **IEmployeeRepository**
- **IDepartmentRepository**
- **IPositionRepository**
- **IAddressRepository**
- **IContactRepository**
- **ISalaryRepository**
- **ILeaveRepository**
- **IEmployeePerformanceRepository**

**Implementations:**
- Uses in-memory HashMap for storage (can be replaced with database)
- Singleton pattern for repository instances
- Standard CRUD operations: save, findById, findAll, delete, exists
- Additional methods: findByEmployeeId (for Salary, Leave, Performance)

#### 4. **Service Package** (`za.ac.cput.service`)
Contains business logic layer:

- **EmployeeService.java**
- **DepartmentService.java**
- **PositionService.java**
- **AddressService.java**
- **ContactService.java**
- **SalaryService.java**
- **LeaveService.java**
- **EmployeePerformanceService.java**

Each service provides CRUD operations and validation.

#### 5. **Controller Package** (`za.ac.cput.controller`)
Contains controller/presentation layer:

- **EmployeeController.java**
- **DepartmentController.java**
- **PositionController.java**
- **AddressController.java**
- **ContactController.java**
- **SalaryController.java**
- **LeaveController.java**
- **EmployeePerformanceController.java**

Controllers handle requests and return appropriate responses.

#### 6. **Util Package** (`za.ac.cput.util`)
Contains the **Helper.java** utility class with helper methods:

- **generateId()** - Generate unique ID using UUID
- **calculateAge()** - Calculate age from date of birth
- **isValidEmail()** - Validate email format
- **isValidPhoneNumber()** - Validate phone number format
- **capitalizeFirstLetter()** - Capitalize first letter of string
- **formatCurrency()** - Format currency amounts
- **isNullOrEmpty()** - Check if string is null or empty
- **isValidSalary()** - Validate salary amount
- **daysBetween()** - Calculate days between two dates
- **isFutureDate()** - Check if date is in future
- **isPastDate()** - Check if date is in past

#### 7. **Test Package** (`za.ac.cput` under src/test/java)
Comprehensive test coverage with JUnit 5:

**Domain Tests:**
- EmployeeTest
- DepartmentTest
- PositionTest
- AddressTest
- ContactTest
- SalaryTest
- LeaveTest
- EmployeePerformanceTest

**Factory Tests:**
- EmployeeFactoryTest

**Repository Tests:**
- EmployeeRepositoryTest

**Service Tests:**
- EmployeeServiceTest

**Controller Tests:**
- EmployeeControllerTest

**Utility Tests:**
- HelperTest

## Architecture Overview

```
User/Client
    ↓
Controller (Presentation Layer)
    ↓
Service (Business Logic Layer)
    ↓
Repository (Data Access Layer)
    ↓
Domain Models (Entity/Business Objects)
    ↓
Storage (In-memory HashMap)
```

## Build and Run Instructions

### Prerequisites
- Java 21 or higher
- Maven 3.6 or higher

### Building the Project

```bash
# Navigate to project directory
cd C:\Users\230526934\IdeaProjects\Employee

# Clean and compile
mvn clean compile

# Run tests
mvn test

# Build package
mvn package
```

### Running the Application

```bash
# Run the main application
java -cp target/classes za.ac.cput.Main

# Or using Maven
mvn exec:java -Dexec.mainClass="za.ac.cput.Main"
```

## Key Design Patterns Used

1. **Singleton Pattern** - Repository instances are singletons
2. **Factory Pattern** - Factory classes for entity creation
3. **Repository Pattern** - Abstraction of data access layer
4. **Service Layer Pattern** - Business logic encapsulation
5. **Layered Architecture** - Clear separation of concerns
6. **DDD Principles** - Entity design focusing on business value

## Dependencies

- **JUnit Jupiter 5.9.3** - For unit testing
- **Java 21** - Compilation and runtime

## Usage Example

```java
// Create entities
Department dept = DepartmentFactory.createDepartment("D001", "IT", "Information Technology", "E001");
Employee emp = EmployeeFactory.createEmployee("E001", "John", "Doe",
    LocalDate.of(1990, 5, 15), "john@example.com",
    LocalDate.of(2020, 1, 15), "D001", "P001", "A001", "C001");

// Use services
EmployeeService empService = new EmployeeService();
Employee created = empService.createEmployee(emp);

// Use controllers
EmployeeController controller = new EmployeeController();
controller.createEmployee(emp);

// Use utility methods
int age = Helper.calculateAge(emp.getDateOfBirth());
String formatted = Helper.formatCurrency(95000.0);
```

## Testing

Run all tests:
```bash
mvn test
```

Run specific test:
```bash
mvn test -Dtest=EmployeeTest
```

Generate test coverage report:
```bash
mvn test jacoco:report
```

## File Statistics

- **Total Classes:** 57
- **Domain Entities:** 8
- **Factory Classes:** 8
- **Repository Interfaces & Implementations:** 16
- **Service Classes:** 8
- **Controller Classes:** 8
- **Utility Classes:** 1
- **Test Classes:** 18

## Future Enhancements

1. Replace in-memory storage with a SQL database
2. Add REST API endpoints using Spring Boot
3. Implement authentication and authorization
4. Add persistence with JPA/Hibernate
5. Create web UI
6. Add logging framework
7. Implement caching strategies
8. Add API documentation with Swagger

## Author
Created as a comprehensive DDD project demonstrating enterprise-level Java architecture.
