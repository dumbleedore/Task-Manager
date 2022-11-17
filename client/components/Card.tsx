import { Box, Button, Heading, Text, HStack } from "@chakra-ui/react";
import React from "react";
import Task from "../interface/task";

export const Card: React.FC<Task> = (props) => {
  return (
    <Box
    onClick={() => console.log(props)}
      bg="secondary"
      m={2}
      w="300px"
      flexGrow={1}
      p={4}
      borderRadius="md"
      boxShadow="md"
      color="white"
    >
      <Heading size="lg">{ props.id + ' '+ props.nome}</Heading>
      <HStack>
        <Text as={"b"}>Descrição</Text>
        <Text>{props.descricao}</Text>
      </HStack>
      <HStack>
        <Text as={"b"}>Status: </Text>
        <Text>{props.status}</Text>
      </HStack>
      <Button colorScheme="blue" mr={2}>Complete Task</Button>
      <Button colorScheme="yellow">Edit Task</Button>
    </Box>
  );
};
