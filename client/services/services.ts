import axios from "axios";
import Task from "../interface/task";
export const fetchTaskManagerList = async () => {
  const response = await axios.get("http://localhost:8080/tarefas");
  return response.data;
};

export const createTask = async (task: Task) => {
  const response = await axios.post("http://localhost:8080/createTarefa", task);
  return new Promise((resolve) => resolve(response.data));
};

export const updateTask = async (taskId : number,task: Task) =>{
  const response = await axios.put(`http://localhost:8080/updateTarefa/${taskId}`, task);
  return response.data;
}
