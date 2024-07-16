## Informe del Proyecto: Integración de React con Spring Boot
# Descripción General
Este proyecto integra una aplicación frontend construida en React con un backend desarrollado en Spring Boot. El objetivo principal de esta integración es generar y mostrar un reporte de tareas que han excedido su tiempo estimado y están en progreso. Este informe detalla el funcionamiento del proyecto, enfocado en React, y destaca los beneficios de usar React para construir aplicaciones web modernas.

**1. Estructura del Proyecto**
El proyecto está dividido en dos partes principales:

-Frontend: Implementado en React, ubicado en la carpeta frontend.
-Backend: Implementado en Spring Boot, ubicado en la carpeta demo.

**2. Frontend en React**
a. Estructura de Archivos
java
Copiar código
![image](https://github.com/user-attachments/assets/3fb5792d-e962-447d-bbf6-84e34a5d55d2)

**b. Explicación del Código**
```
App.js
javascript
Copiar código
import React from 'react';
import TaskReport from './components/TaskReport';
import './App.css';

const App = () => {
  return (
    <div className="App">
      <TaskReport />
    </div>
  );
};

export default App;
```
App.js es el componente principal que se encarga de renderizar el componente TaskReport.
```
TaskReport.js

javascript
Copiar código
import React, { useState } from 'react';
import axios from 'axios';

const TaskReport = () => {
  const [startDate, setStartDate] = useState('');
  const [endDate, setEndDate] = useState('');
  const [tasks, setTasks] = useState([]);

  const fetchTasks = async () => {
    try {
      const response = await axios.get('/api/tareas/reporte', {
        params: {
          fechaInicio: startDate,
          fechaFin: endDate,
        },
      });
      setTasks(response.data);
    } catch (error) {
      console.error('Error fetching tasks', error);
    }
  };

  return (
    <div>
      <h1>Reporte de Tareas Pasadas de su Estimado y En Progreso</h1>
      <div>
        <label>Fecha Inicio: </label>
        <input type="date" value={startDate} onChange={(e) => setStartDate(e.target.value)} />
        <label>Fecha Fin: </label>
        <input type="date" value={endDate} onChange={(e) => setEndDate(e.target.value)} />
        <button onClick={fetchTasks}>Generar Reporte</button>
      </div>
      <table>
        <thead>
          <tr>
            <th>Empleado</th>
            <th>Tarea</th>
            <th>Fecha Inicio</th>
            <th>Fecha Estimado</th>
            <th>Proyecto</th>
            <th>Días Pasados</th>
          </tr>
        </thead>
        <tbody>
          {tasks.map((task) => (
            <tr key={task.idEmpleado + task.fechaInicio}>
              <td>{task.nombreEmpleado} {task.apellidoEmpleado}</td>
              <td>{task.tarea}</td>
              <td>{new Date(task.fechaInicio).toLocaleDateString()}</td>
              <td>{new Date(task.fechaEstimado).toLocaleDateString()}</td>
              <td>{task.proyecto}</td>
              <td>{task.diasPasados}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default TaskReport;
```
TaskReport.js es el componente encargado de:

Manejo de Estado:

startDate y endDate: Fechas de inicio y fin para el rango de búsqueda.
tasks: Lista de tareas obtenidas desde el backend.
Función fetchTasks:

Utiliza axios para hacer una solicitud GET al endpoint /api/tareas/reporte del backend.
Pasa startDate y endDate como parámetros.
Actualiza el estado de tasks con los datos recibidos.
Renderizado:

Muestra un formulario con campos para seleccionar las fechas y un botón para generar el reporte.
Renderiza una tabla con las tareas obtenidas.

## Ejecución del Proyecto
**a. Ejecución del Backend**
Navega a la carpeta del proyecto Spring Boot.
Ejecuta el comando:
```
sh
```
Copiar código
```
./mvnw spring-boot:run
```
**b. Ejecución del Frontend**
Navega a la carpeta del proyecto React.
Ejecuta el comando:
```
sh
```
Copiar código
```
npm start
```
## Conclusión

La integración de React con Spring Boot ha demostrado ser una solución efectiva y moderna para construir aplicaciones web robustas y escalables. En este proyecto, hemos desarrollado una aplicación completa que permite generar y visualizar un reporte de tareas atrasadas, utilizando la potencia de React para el frontend y la flexibilidad de Spring Boot para el backend. 

#Puntos Clave:

1. **Componentización y Reutilización**:
   - React permite descomponer la interfaz de usuario en componentes modulares y reutilizables, lo que facilita el mantenimiento y la extensión del código.

2. **Manejo Eficiente del Estado**:
   - Con React, el manejo del estado de la aplicación es sencillo y eficiente, permitiendo la creación de interfaces de usuario dinámicas e interactivas.

3. **Ecosistema Rico**:
   - La amplia gama de bibliotecas y herramientas disponibles en el ecosistema de React, como `axios` para realizar solicitudes HTTP, agiliza el desarrollo y mejora la funcionalidad de la aplicación.

4. **Backend Sólido**:
   - Spring Boot proporciona una plataforma robusta y flexible para el desarrollo de aplicaciones backend, con soporte para RESTful APIs, seguridad, y una fácil integración con bases de datos.

5. **Comunicación Fluida**:
   - La configuración de un proxy en React permite una comunicación fluida y sin problemas con el backend de Spring Boot, facilitando el desarrollo y las pruebas locales.

# Beneficios de la Solución:

- **Escalabilidad**: La arquitectura modular de React y la robustez de Spring Boot permiten escalar la aplicación con facilidad.
- **Desempeño Mejorado**: La utilización del DOM virtual de React y la eficiencia de Spring Boot garantizan un desempeño óptimo de la aplicación.
- **Mantenimiento Simplificado**: La separación clara entre frontend y backend, junto con la reutilización de componentes en React, simplifica el mantenimiento y la actualización de la aplicación.
- **Experiencia de Usuario Mejorada**: La capacidad de React para crear interfaces de usuario dinámicas y responsivas mejora significativamente la experiencia del usuario final.
