import axios from "axios";
import Task from "../interface/task";
export const fetchTaskManagerList = async () => {
  const { data } = await axios.get("http://localhost:8080/tarefas");
  console.log(data);
  return data;
};

export const createTask = async (task: Task) => {
  const { data } = await axios.post("http://localhost:8080/createTarefa", task);
  return new Promise((resolve) => resolve(data));
};

export const updateTask = async (taskId : number,task: Task) =>{
  const { data } = await axios.post(`http://localhost:8080/updateTarefa${taskId}`, task);
  return new Promise((resolve) => resolve(data));
}
