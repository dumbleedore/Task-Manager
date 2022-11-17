import {
  Box,
  Button,
  Center,
  Flex,
} from "@chakra-ui/react";
import { Card } from "../components/Card";
import React from "react";
import { createTask, fetchTaskManagerList } from "../services/services";
import Task from "../interface/task";
export default function Home() {
  const [tasks, setTasks] = React.useState<Task[]>([]);
  const [form, setForm] = React.useState<Task>({
    id: 0,
    nome: "",
    descricao: "",
    status: "aberto",
    data: "",
  });
  const handleClick = async () => {
    await createTask(form);
    fetchTaskManagerList().then((data) => setTasks(data));
  };
  React.useEffect(() => {
    fetchTaskManagerList().then((data) => setTasks(data));
  }, []);
  return (
    <Box bg="primary">
      <Flex wrap={"wrap"}>
        {tasks &&
          tasks.map((item) => (
            <Card key={item.id}
             {...item}
            ></Card>
          ))}
      </Flex>
      <Box>
        <Center>
          <Button  colorScheme={"blue"}>
            Create Task
          </Button>
        </Center>
      </Box>
    </Box>
  );
}
