import {
  Box,
  Button,
  Center,
  Flex,
  useDisclosure,
  Input,
  Textarea,
  Modal,
  ModalBody,
  ModalCloseButton,
  ModalContent,
  ModalFooter,
  ModalHeader,
  ModalOverlay,
  Stack,
} from "@chakra-ui/react";
import { Card } from "../components/card";
import React from "react";
import { createTask, fetchTaskManagerList } from "../services/services";
import Task from "../interface/task";
export default function Home() {
  const { isOpen, onOpen, onClose } = useDisclosure();
  const [tasks, setTasks] = React.useState<Task[]>([]);
  const [form, setForm] = React.useState<Task>({
    nome: "",
    descricao: "",
    status: "fechado",
    data: "",
  });
  React.useEffect(() => {
    fetchTaskManagerList().then((data) => setTasks(data));
  }, []);
  return (
    <Box bg="primary">
      <Flex wrap={"wrap"}>
        {tasks && tasks.map((item) => <Card key={item.nome}></Card>)}
      </Flex>
      <Box>
        <Center>
          <Button onClick={onOpen} colorScheme={"blue"}>
            Create Task
          </Button>
        </Center>
      </Box>
      <Modal isOpen={isOpen} onClose={onClose}>
        <ModalOverlay />
        <ModalContent>
          <ModalHeader>Create Task</ModalHeader>
          <ModalCloseButton />
          <ModalBody>
            <Stack>
              <Input
                placeholder="Task Name"
                onChange={(event) => {
                  setForm({ ...form, nome: event.target.value });
                }}
              />
              <Textarea
                placeholder="Task Description"
                onChange={(event) => {
                  setForm({ ...form, descricao: event.target.value });
                }}
              />
              <Input
                placeholder="Select Date"
                type="date"
                onChange={(event) => {
                  setForm({ ...form, data: event.target.value });
                }}
              />
            </Stack>
          </ModalBody>
          <ModalFooter>
            <Button onClick={() => createTask(form)} colorScheme="blue">
              Create
            </Button>
          </ModalFooter>
        </ModalContent>
      </Modal>
    </Box>
  );
}
