import axios from "axios";
import Task from "../interface/task";
export const fetchTaskManagerList = async () => {
  const { data } = await axios.get("http://localhost:8080/tarefas");
  return data;
};

export const createTask = async (task: Task) => {
  const { data } = await axios.post("http://localhost:8080/createTarefa", task);
  return data;
};
