import { Box, Button, Heading, Text, HStack } from "@chakra-ui/react";
import React from "react";

// create a simple card component with description //
export const Card = () => {
  return (
    <Box
      bg="secondary"
      w={"100%"}
      m={2}
      p={4}
      borderRadius="md"
      boxShadow="md"
      color="white"
      flex={"1 0 30%"}
    >
      <Heading size="lg">Task</Heading>
      <Text>Task Description</Text>
      <HStack>
        <Text as={"b"}>Status: </Text>
        <Text>Not Started</Text>
      </HStack>
      <Button colorScheme="blue">Complete Task</Button>
    </Box>
  );
};
