import { useState, useEffect } from 'react';
import './App.css';

function App() {
  const [tasks, setTasks] = useState([]);
  const [newTask, setNewTask] = useState("");

  useEffect(() => {
    fetchTasks();
  }, []);

  const fetchTasks = () => {
    fetch("http://localhost:8080/task/all")
      .then(response => response.json())
      .then(data => {
        console.log("Fetched tasks:", data); // Log the fetched tasks
        setTasks(data.map(task => ({
          ...task,
          taskName: task.taskName.replace(/^"|"$/g, '') // Remove quotes from taskName
        })));
      });
  };

  const addTask = () => {
    fetch("http://localhost:8080/task/add", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify({ taskName: newTask }) // Send taskName as an object
    }).then(() => {
      fetchTasks(); // Fetch the updated list of tasks
      setNewTask("");
    });
  };

  const deleteTask = (id) => {
    fetch(`http://localhost:8080/task/delete/${id}`, {
      method: "DELETE"
    }).then(() => {
      setTasks(tasks.filter(task => task.id !== id));
    });
  };

  const toggleTaskDone = (id, done) => {
    fetch(`http://localhost:8080/task/update/${id}`, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify({ done: !done }) // Toggle the done status
    }).then(() => {
      fetchTasks(); // Fetch the updated list of tasks
    });
  };

  return (
    <div className="app">
      <h1>To-Do List</h1>
      <div className="input-container">
        <input 
          type="text" 
          value={newTask} 
          onChange={(e) => setNewTask(e.target.value)} 
          placeholder="Add a new task" 
        />
        <button onClick={addTask}>Add</button>
      </div>
      <ul className="task-list">
        {tasks.map(task => (
          <li key={task.id} className="task-item">
            <span style={{ textDecoration: task.done ? 'line-through' : 'none' }}>
              {task.taskName}
            </span>
            <button onClick={() => toggleTaskDone(task.id, task.done)}>
              {task.done ? 'Undo' : 'Done'}
            </button>
            <button onClick={() => deleteTask(task.id)}>Delete</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;